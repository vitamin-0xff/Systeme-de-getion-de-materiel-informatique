
package com.hardware.managmentsystem.hardwaremanagementsystem.computer

import com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.AttributeMetadata
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.AttributeType
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.*

data class ComputerRequest(
    val model: String,
    val marqueId: UUID,
    val serialNumber: String,
    val chipsetMotherboard: String,
    val active: Boolean = true,
    val type: ComputerType = ComputerType.PC,
    val working: Boolean = true,
    val yearBuyIn: Int? = null,
    val warrantyEndDate: LocalDate? = null,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null
)

data class ComputerUpdate(
    val model: String? = null,
    val marqueId: UUID? = null,
    val serialNumber: String? = null,
    val chipsetMotherboard: String? = null,
    val active: Boolean? = null,
    val type: ComputerType? = null,
    val working: Boolean? = null,
    val yearBuyIn: Int? = null,
    val warrantyEndDate: LocalDate? = null,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null
)

data class ComputerResponse(
    val id: UUID,
    val model: String,
    val marqueId: UUID,
    val serialNumber: String,
    val chipsetMotherboard: String,
    val active: Boolean,
    val type: ComputerType,
    val working: Boolean,
    val yearBuyIn: Int?,
    val warrantyEndDate: LocalDate?,
    val providerId: UUID?,
    val purchaseDate: LocalDate?
)

fun ComputerRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) =
    ComputerEntity(
        model = model,
        marque = marque,
        serialNumber = serialNumber,
        chipsetMotherboard = chipsetMotherboard,
        active = active,
        type = type,
        working = working,
        yearBuyIn = yearBuyIn,
        warrantyEndDate = warrantyEndDate,
        provider = provider,
        purchaseDate = purchaseDate
    )

fun ComputerEntity.applyUpdate(u: ComputerUpdate, marque: MarqueEntity?, provider: ProviderEntity?) {
    u.model?.let { model = it }
    if (u.serialNumber != null) serialNumber = u.serialNumber
    if (u.chipsetMotherboard != null) chipsetMotherboard = u.chipsetMotherboard
    u.active?.let { active = it }
    u.type?.let { type = it }
    u.working?.let { working = it }
    if (u.yearBuyIn != null) yearBuyIn = u.yearBuyIn
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
}

fun ComputerEntity.toResponse() = ComputerResponse(
    id = id!!,
    model = model,
    marqueId = marque.id!!,
    serialNumber = serialNumber,
    chipsetMotherboard = chipsetMotherboard,
    active = active,
    type = type,
    working = working,
    yearBuyIn = yearBuyIn,
    warrantyEndDate = warrantyEndDate,
    providerId = provider?.id,
    purchaseDate = purchaseDate
)

object DefaultAttributesOfComputer {
    val defaultAttributesOfComputerMetaData: List<AttributeMetadata> = listOf(
        AttributeMetadata(
            attributeName = "Model",
            attributeCode = "model",
            attributeType = AttributeType.ENUM
        ),
        AttributeMetadata(
            attributeName = "Type",
            attributeCode = "type",
            attributeType = AttributeType.ENUM
        ),
        AttributeMetadata(
            attributeName = "Active",
            attributeCode = "active",
            attributeType = AttributeType.BOOLEAN
        ),
        AttributeMetadata(
            attributeName = "Working",
            attributeCode = "working",
            attributeType = AttributeType.BOOLEAN
        ),
        AttributeMetadata(
            attributeName = "Marque",
            attributeCode = "marque.label",
            attributeType = AttributeType.ENUM
        )
    )
}