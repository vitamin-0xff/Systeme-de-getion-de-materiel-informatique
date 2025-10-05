package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.mouse

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.PeripheralEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@DiscriminatorValue("MOUSE")
class MouseEntity(
    var dpi: Int? = null,
    @Column(name = "button_count")
    var buttonCount: Int = 3,
    @Column(name = "is_wireless")
    var isWireless: Boolean = false,
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