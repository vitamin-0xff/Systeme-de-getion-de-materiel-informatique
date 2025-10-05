package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.keyboard

import com.hardware.managmentsystem.hardwaremanagementsystem._config.KeyboardLayout
import com.hardware.managmentsystem.hardwaremanagementsystem._config.KeyboardSwitch
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import java.time.LocalDate
import java.util.UUID

data class KeyboardRequest(
    val layout: KeyboardLayout = KeyboardLayout.AZERTY,
    val switchType: KeyboardSwitch = KeyboardSwitch.NORMAL,
    val backLight: Boolean = false,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class KeyboardUpdate(
    val layout: KeyboardLayout? = null,
    val switchType: KeyboardSwitch? = null,
    val backLight: Boolean? = null,
    val label: String? = null,
    val connectivityType: String? = null,
    val serialNumber: String? = null,
    val marqueId: UUID? = null,
    val providerId: UUID? = null,
    val purchaseDate: LocalDate? = null,
    val warrantyEndDate: LocalDate? = null
)

data class KeyboardResponse(
    val id: UUID,
    val layout: KeyboardLayout,
    val switchType: KeyboardSwitch,
    val backLight: Boolean,
    val label: String,
    val connectivityType: String,
    val serialNumber: String,
    val marqueId: UUID,
    val providerId: UUID?,
    val purchaseDate: LocalDate?,
    val warrantyEndDate: LocalDate?
)

fun KeyboardRequest.toEntity(marque: MarqueEntity, provider: ProviderEntity?) = 
    KeyboardEntity(
        layout = layout,
        switchType = switchType,
        backLight = backLight,
        label = label,
        connectivityType = connectivityType,
        serialNumber = serialNumber,
        marqueEntity = marque,
        providerEntity = provider,
        purchaseDate = purchaseDate,
        warrantyEndDate = warrantyEndDate
    )

fun KeyboardEntity.applyUpdate(u: KeyboardUpdate, marque: MarqueEntity?, provider: ProviderEntity?) {
    u.layout?.let { layout = it }
    u.switchType?.let { switchType = it }
    u.backLight?.let { backLight = it }
    u.label?.let { label = it }
    u.connectivityType?.let { connectivityType = it }
    u.serialNumber?.let { serialNumber = it }
    if (u.purchaseDate != null) purchaseDate = u.purchaseDate
    if (u.warrantyEndDate != null) warrantyEndDate = u.warrantyEndDate
    if (u.providerId == null) this.provider = null
    else provider?.let { this.provider = it }
}

fun KeyboardEntity.toResponse() = KeyboardResponse(
    id = id!!,
    layout = layout,
    switchType = switchType,
    backLight = backLight,
    label = label,
    connectivityType = connectivityType,
    serialNumber = serialNumber,
    marqueId = marque.id!!,
    providerId = provider?.id,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate
)
