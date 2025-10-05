package com.hardware.managmentsystem.hardwaremanagementsystem._core.filter

data class FilterCountModel(
    val model: String,
    val modelCode: String,
    val modelDisplayName: String,
    val countAttributes: List<CountAttribute>
)

data class CountAttribute(
    val attributeMetadata: AttributeMetadata,
    val possibleValues: List<PossibleValue>,
    val rangeSupport: Boolean = false,
    val isMultiselect: Boolean = true,
    val isSearchable: Boolean = false,
    val isShown: Boolean = true,
    val showPriority: Int = 0,
    val version: Int = 1
)

data class PossibleValue(
    val value: String,
    val valueDisplayName: String,
    val valueCode: String,
    val count: Long,
    val isApplied: Boolean = false,
    val valueSortOrder: Int = 0
)

data class PossibleValueMetadata(
    val possibleValueName: String,
    val possibleValueCode: String,
    val possibleValueType: AttributeType,
)

enum class AttributeType {
    ENUM,
    BOOLEAN
}

data class ApplyFilterRequest(
    val model: String,
    val modelCode: String,
    val countAttributes: List<CountAttribute>
)

data class CountAttributeApplied(
    val attributeName: String,
    val attributeCode: String,
    val appliedValues: List<AppliedValue>
)

data class AppliedValue(
    val value: Any,
    val valueCode: Any
)

data class AttributeCount(
    val valueName: String,
    val count: Long
)
data class AttributeMetadata(
    val attributeName: String,
    val attributeCode: String, // example att_x or join_x.att_x, join_x.join_y.att_z
    val attributeType: AttributeType
)

data class AppliedAttribute(
    val attributeMetadata: AttributeMetadata,
    val appliedValues: List<AppliedValue>
)

data class FilterAppliedRequest(
    val model: String,
    val modelCode: String,
    val appliedAttributesRequest: List<AppliedAttribute>
)

data class ModelMetadata(
    val modelName: String,
    val modelCode: String,
)