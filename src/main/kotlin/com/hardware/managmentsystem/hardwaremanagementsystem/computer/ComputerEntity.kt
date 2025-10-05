package com.hardware.managmentsystem.hardwaremanagementsystem.computer

import com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType
import com.hardware.managmentsystem.hardwaremanagementsystem.hardware.HardwareEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.EnumType.*
import jakarta.persistence.Enumerated
import java.time.LocalDate

@Entity
@DiscriminatorValue("COMPUTER")
class ComputerEntity(
    var model: String,
    marque: MarqueEntity,
    serialNumber: String,
    var chipsetMotherboard: String,
    active: Boolean = true,
    @Enumerated(STRING) var type: ComputerType = ComputerType.PC,
    var working: Boolean = true,
    var yearBuyIn: Int? = null,
    warrantyEndDate: LocalDate? = null,
    provider: ProviderEntity? = null,
    purchaseDate: LocalDate? = null
) : HardwareEntity(marque = marque, serialNumber = serialNumber, active = active, warrantyEndDate = warrantyEndDate, provider = provider, purchaseDate = purchaseDate)