package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.keyboard

import com.hardware.managmentsystem.hardwaremanagementsystem._config.KeyboardLayout
import com.hardware.managmentsystem.hardwaremanagementsystem._config.KeyboardSwitch
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.PeripheralEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDate

@Entity
@DiscriminatorValue("KEYBOARD")
class KeyboardEntity(
    @Enumerated(EnumType.STRING) var layout: KeyboardLayout = KeyboardLayout.AZERTY,
    @Column(name = "switch_type")
    @Enumerated(EnumType.STRING) var switchType: KeyboardSwitch = KeyboardSwitch.NORMAL,
    @Column(name = "back_light") var backLight: Boolean = false,
    label: String,
    connectivityType: String,
    serialNumber: String,
    marqueEntity: MarqueEntity,
    providerEntity: ProviderEntity? = null,
    purchaseDate: LocalDate? = null,
    warrantyEndDate: LocalDate? = null
) : PeripheralEntity(
    label = label,
    connectivityType = connectivityType,
    serialNumber = serialNumber,
    marque = marqueEntity,
    provider = providerEntity,
    purchaseDate = purchaseDate,
    warrantyEndDate = warrantyEndDate
)