package com.hardware.managmentsystem.hardwaremanagementsystem.hardware

import com.hardware.managmentsystem.hardwaremanagementsystem._config.HardwareStatus
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.UUID

data class HardwareRequest(
    val marqueId: UUID,
    val active: Boolean = true,
    val status: HardwareStatus = HardwareStatus.WORKING,
    val serialNumber: String,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null,
    val providerId: UUID? = null
)

data class HardwareUpdate(
    val marqueId: UUID? = null,
    val active: Boolean? = null,
    val status: HardwareStatus? = null,
    val serialNumber: String? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null,
    val providerId: UUID? = null
)

data class HardwareResponse(
    val id: UUID,
    val marqueId: UUID,
    val active: Boolean,
    val status: HardwareStatus,
    val serialNumber: String,
    val purchaseDate: LocalDate?,
    val warrantyEndDate: LocalDate?,
    val providerId: UUID?
)

fun HardwareRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) =
    HardwareEntity(marque, active, status, serialNumber, purchaseDate, warrantyEndDate, provider)

fun HardwareEntity.applyUpdate(u: HardwareUpdate, marque: MarqueEntity?, provider: ProviderEntity?) {
    // Note: marque is val, so we can't update it directly in this inheritance structure
    u.active?.let { active = it }
    u.status?.let { status = it }
    if (u.serialNumber != null) serialNumber = u.serialNumber
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
}

fun HardwareEntity.toResponse() = HardwareResponse(
    id = id!!,
    marqueId = marque.id!!,
    active = active,
    status = status,
    serialNumber = serialNumber,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate,
    providerId = provider?.id
)
