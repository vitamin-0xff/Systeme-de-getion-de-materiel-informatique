package com.hardware.managmentsystem.hardwaremanagementsystem._core.filter

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Path
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.stereotype.Service

@Service
class FilterCountService(
    @PersistenceContext
    private val entityManager: EntityManager
) {

    /**
     * @author AMINE ESSID
     * @return Each attribute with values counted
     * @sample
     *  {
     *    [
     *    attX: [
     *      { valueY: 3 },
     *      { valueZ: 6 }
     *      ...
     *    ]
     *    ...
     *    ]
     *  }
     *  @param filterAppliedRequest Filter request received which indicate what filter applied
     *  @param targetEntity Target entity we are already make this process on
     *  @param attributesMetadata Attributes metadata expected
     *  @param modelMetadata Contains the name of model and the code name
     */
    fun <T: BaseEntity> getAttributesCount(
        filterAppliedRequest: FilterAppliedRequest,
        targetEntity: Class<T>,
        attributesMetadata: List<AttributeMetadata>,
        modelMetadata: ModelMetadata
    ): FilterCountModel {
        filterAppliedRequest.appliedAttributesRequest.forEach {
            if(!checkAttributeSupported(it.attributeMetadata, attributesMetadata)) {
                throw Exception("Attribute ${it.attributeMetadata.attributeName} is not supported")
            }
        }

        val appliedAttributes = mutableListOf<CountAttribute>()
        for (filterAtt in attributesMetadata) {
            val cb: CriteriaBuilder = entityManager.criteriaBuilder
            val cq: CriteriaQuery<Array<Any>> = cb.createQuery(Array<Any>::class.java)
            val root: Root<T> = cq.from(targetEntity)

            val attributesWherePredicate = buildPredicate(filterAppliedRequest, filterAtt, root, cb)
            val countAttribute = getAttributeValuesCount(filterAtt, attributesWherePredicate, cb, cq, root)
            appliedAttributes.add(CountAttribute(filterAtt, possibleValues = countAttribute.map { PossibleValue(it.valueName, it.valueName, it.valueName, count = it.count) }))
        }
        return FilterCountModel(
            model = modelMetadata.modelName,
            modelCode = modelMetadata.modelCode,
            modelDisplayName = modelMetadata.modelName,
            countAttributes = appliedAttributes
        )
    }

    /**
     * @author AMINE ESSID
     * check if all attributes metadata aligned with expectation
     * @return true if correct else false
     */
    private fun checkAttributeSupported(attributeMetadata: AttributeMetadata, neededAttributesMetadata: List<AttributeMetadata>): Boolean {
        return neededAttributesMetadata.any { it.attributeCode == attributeMetadata.attributeCode && it.attributeType == attributeMetadata.attributeType }
    }

    /**
     * @author AMINE ESSID
     * resolve path of expression
     * @return path
     * @exception javax.management.AttributeNotFoundException is not attribute with such name
     */
    private fun <T> pathResolver(root: Root<T>, attributeMetadata: AttributeMetadata): Path<out Any> {
        val pathFragments = attributeMetadata.attributeCode.split(".")
        val path = if(pathFragments.size > 2) {
            throw Exception("Two nested Join is not supported for now")
        }else if (pathFragments.size == 2) {
            val joinPath = root.join<Any, T>(pathFragments[0])
            if(attributeMetadata.attributeType == AttributeType.ENUM) joinPath.get<String>(pathFragments[1]) else joinPath.get<Boolean>(pathFragments[1])
        }else {
            if(attributeMetadata.attributeType == AttributeType.ENUM) root.get<String>(attributeMetadata.attributeCode) else root.get<Boolean>(attributeMetadata.attributeCode)
        }
        return path
    }

    private fun <T> getAttributeValuesCount(
         attributeMetadata: AttributeMetadata,
         whereClausePredicate: Predicate? = null,
         cb: CriteriaBuilder,
         cq: CriteriaQuery<Array<Any>>,
         root: Root<T>
    ): List<AttributeCount> {

        fun valueNameResolver(value: Any): String {
            return when (value) {
                is Boolean -> if (value) attributeMetadata.attributeName else "Not ${attributeMetadata.attributeName}"
                is Enum<*> -> value.name
                else -> value as String
            }
        }
        val attExpression = pathResolver(root, attributeMetadata)
        cq.multiselect(attExpression, cb.count(root))
        cq.where(whereClausePredicate)
        cq.groupBy(attExpression)
        val res = entityManager.createQuery(cq).resultList
        return res.map { AttributeCount( valueNameResolver(it[0]), it[1] as Long) }
    }
    /**
     * BUILD PREDICATE FOR EACH ATTRIBUTE WHERE A PREDICATE FOR EACH IS CONSTRUCTED FROM OTHERS' ATTRIBUTE FILTERS
     * @sample
     * 1 - filter others' filters and get each
     * 2 - each filter construct or with values with or predicate like so if we got type is ('x', 'y', 'z') we need type = x or type = y or type = z predicate
     * 3 - now for each attribute we need each or predicate and construct 'and' predicate like so if we got type = x or x = y or x = z, model = z or model = k or model = h we need 'and' all of them
     * 4 - that's it!
     */

    private fun <T> buildPredicate(request: FilterAppliedRequest, targetAttributeMetadata: AttributeMetadata, root: Root<T>, cb: CriteriaBuilder): Predicate {
        return cb.and(*request.appliedAttributesRequest.
        filter { it.attributeMetadata.attributeCode != targetAttributeMetadata.attributeCode }.
        map {
            attribute -> cb.or(*attribute.appliedValues.
            map {
                    val path = pathResolver(root, attribute.attributeMetadata)
                    cb.equal(path, it.valueCode)
                 }.toTypedArray())
        }.toTypedArray()
        )
    }
}