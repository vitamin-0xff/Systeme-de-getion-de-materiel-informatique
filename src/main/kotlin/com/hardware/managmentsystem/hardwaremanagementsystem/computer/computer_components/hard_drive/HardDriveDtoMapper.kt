package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive

import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.AttributeMetadata
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.AttributeType
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import java.util.UUID

data class HardDriveRequest(
    val name: String,
    val type: String,
    val size: Long,
    val sizeUnit: SizeUnit = SizeUnit.GB,
    val isSsd: Boolean = true,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class HardDriveUpdate(
    val name: String? = null,
    val type: String? = null,
    val size: Long? = null,
    val sizeUnit: SizeUnit? = null,
    val isSsd: Boolean? = null,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class HardDriveResponse(
    val id: UUID,
    val name: String,
    val type: String,
    val size: Long,
    val sizeUnit: SizeUnit,
    val isSsd: Boolean,
    val marqueId: UUID?,
    val imageUrl: String?
)

fun HardDriveRequest.toEntity(marque: MarqueEntity?) = HardDriveEntity(
    name = name,
    type = type,
    size = size,
    sizeUnit = sizeUnit,
    isSsd = isSsd,
    marque = marque,
    imageUrl = imageUrl
)

fun HardDriveEntity.applyUpdate(u: HardDriveUpdate, marque: MarqueEntity?) {
    u.name?.let { name = it }
    u.type?.let { type = it }
    u.size?.let { size = it }
    u.sizeUnit?.let { sizeUnit = it }
    u.isSsd?.let { isSsd = it }
    if (u.imageUrl != null) imageUrl = u.imageUrl
    if (u.marqueId == null) this.marque = null
    else marque?.let { this.marque = it }
}

fun HardDriveEntity.toResponse() = HardDriveResponse(
    id = id!!,
    name = name,
    type = type,
    size = size,
    sizeUnit = sizeUnit,
    isSsd = isSsd,
    marqueId = marque?.id,
    imageUrl = imageUrl
)

val hardDriveAttributesMetadata: List<AttributeMetadata> = listOf(
    AttributeMetadata(
        attributeName = "Type",
        attributeCode = "type",
        attributeType = AttributeType.ENUM
    ),
    AttributeMetadata(
        attributeName = "ssid",
        attributeCode = "isSsd",
        attributeType = AttributeType.BOOLEAN
    )
)
