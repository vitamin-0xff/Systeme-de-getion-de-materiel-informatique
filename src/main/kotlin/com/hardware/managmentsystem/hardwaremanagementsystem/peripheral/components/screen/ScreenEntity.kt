package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.screen

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.PeripheralEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@DiscriminatorValue("SCREEN")
class ScreenEntity(
    @Column(name = "aspect_ratio")
    var aspectRatio: String? = null,
    @Column(name = "refresh_rate")
    var refreshRate: String? = null,
    @Column(name = "screen_size_inches")
    var screenSizeInches: String,
    var resolution: String,
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