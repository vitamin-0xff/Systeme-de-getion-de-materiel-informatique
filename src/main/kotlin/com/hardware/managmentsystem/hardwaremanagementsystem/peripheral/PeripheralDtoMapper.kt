package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.UUID

data class PeripheralRequest(
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID? = null,
    val active: Boolean = true,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class PeripheralUpdate(
    val label: String? = null,
    val connectivityType: String? = null,
    val serialNumber: String? = null,
    val marqueId: UUID? = null,
    val providerId: UUID? = null,
    val active: Boolean? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class PeripheralResponse(
    val id: UUID,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID?,
    val active: Boolean,
    val purchaseDate: LocalDate?,
    val warrantyEndDate: LocalDate?
)

fun PeripheralRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) = 
    PeripheralEntity(
        label = label,
        connectivityType = connectivityType,
        serialNumber = serialNumber,
        marque = marque,
        provider = provider,
        active = active,
        purchaseDate = purchaseDate,
        warrantyEndDate = warrantyEndDate
    )

fun PeripheralEntity.applyUpdate(u: PeripheralUpdate, marque: MarqueEntity?, provider: ProviderEntity?) {
    u.label?.let { label = it }
    u.connectivityType?.let { connectivityType = it }
    u.serialNumber?.let { serialNumber = it }
    u.active?.let { active = it }
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
    // Note: marque is inherited from HardwareEntity and might not be updatable
}

fun PeripheralEntity.toResponse() = PeripheralResponse(
    id = id!!,
    label = label,
    connectivityType = connectivityType,
    serialNumber = serialNumber,
    marqueId = marque.id!!,
    providerId = provider?.id,
    active = active,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate
)
