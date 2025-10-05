package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.mouse

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.UUID

data class MouseRequest(
    val dpi: Int? = null,
    val buttonCount: Int = 3,
    val isWireless: Boolean = false,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class MouseUpdate(
    val dpi: Int? = null,
    val buttonCount: Int? = null,
    val isWireless: Boolean? = null,
    val label: String? = null,
    val connectivityType: String? = null,
    val serialNumber: String? = null,
    val marqueId: UUID? = null,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class MouseResponse(
    val id: UUID,
    val dpi: Int?,
    val buttonCount: Int,
    val isWireless: Boolean,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID?,
    val purchaseDate: LocalDate?,
    val warrantyEndDate: LocalDate?
)

fun MouseRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) = 
    MouseEntity(
        dpi = dpi,
        buttonCount = buttonCount,
        isWireless = isWireless,
        label = label,
        connectivityType = connectivityType,
        serialNumber = serialNumber,
        marqueEntity = marque,
        providerEntity = provider,
        purchaseDate = purchaseDate,
        warrantyEndDate = warrantyEndDate
    )

fun MouseEntity.applyUpdate(u: MouseUpdate, provider: ProviderEntity?) {
    if (u.dpi != null) dpi = u.dpi
    u.buttonCount?.let { buttonCount = it }
    u.isWireless?.let { isWireless = it }
    u.label?.let { label = it }
    u.connectivityType?.let { connectivityType = it }
    u.serialNumber?.let { serialNumber = it }
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
}

fun MouseEntity.toResponse() = MouseResponse(
    id = id!!,
    dpi = dpi,
    buttonCount = buttonCount,
    isWireless = isWireless,
    label = label,
    connectivityType = connectivityType,
    serialNumber = serialNumber,
    marqueId = marque.id!!,
    providerId = provider?.id,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate
)
