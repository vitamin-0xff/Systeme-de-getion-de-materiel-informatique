
package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.screen

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.UUID

data class ScreenRequest(
    val aspectRatio: String? = null,
    val refreshRate: String? = null,
    val screenSizeInches: String,
    val resolution: String,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class ScreenUpdate(
    val aspectRatio: String? = null,
    val refreshRate: String? = null,
    val screenSizeInches: String? = null,
    val resolution: String? = null,
    val label: String? = null,
    val connectivityType: String? = null,
    val serialNumber: String? = null,
    val marqueId: UUID? = null,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class ScreenResponse(
    val id: UUID,
    val aspectRatio: String?,
    val refreshRate: String?,
    val screenSizeInches: String,
    val resolution: String,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID?,
    val purchaseDate: LocalDate?,
    val warrantyEndDate: LocalDate?
)

fun ScreenRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) = 
    ScreenEntity(
        aspectRatio = aspectRatio,
        refreshRate = refreshRate,
        screenSizeInches = screenSizeInches,
        resolution = resolution,
        label = label,
        connectivityType = connectivityType,
        serialNumber = serialNumber,
        marqueEntity = marque,
        providerEntity = provider,
        purchaseDate = purchaseDate,
        warrantyEndDate = warrantyEndDate
    )

fun ScreenEntity.applyUpdate(u: ScreenUpdate, marque: MarqueEntity?, provider: ProviderEntity?) {
    if (u.aspectRatio != null) aspectRatio = u.aspectRatio
    if (u.refreshRate != null) refreshRate = u.refreshRate
    u.screenSizeInches?.let { screenSizeInches = it }
    u.resolution?.let { resolution = it }
    u.label?.let { label = it }
    u.connectivityType?.let { connectivityType = it }
    u.serialNumber?.let { serialNumber = it }
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
}

fun ScreenEntity.toResponse() = ScreenResponse(
    id = id!!,
    aspectRatio = aspectRatio,
    refreshRate = refreshRate,
    screenSizeInches = screenSizeInches,
    resolution = resolution,
    label = label,
    connectivityType = connectivityType,
    serialNumber = serialNumber,
    marqueId = marque.id!!,
    providerId = provider?.id,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate
)
