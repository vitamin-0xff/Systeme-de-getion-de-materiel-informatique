package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral

import com.hardware.managmentsystem.hardwaremanagementsystem.hardware.HardwareEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType

import java.time.LocalDate

@Entity
@DiscriminatorValue("PERIPHERAL")
@DiscriminatorColumn(name = "p_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class PeripheralEntity(
    var label: String,
    var connectivityType: String,
    serialNumber: String,
    marque: MarqueEntity,
    provider: ProviderEntity? = null,
    active: Boolean = true,
    purchaseDate: LocalDate? = null,
    warrantyEndDate: LocalDate? = null,
) : HardwareEntity(marque = marque, serialNumber = serialNumber, provider = provider, active = active, purchaseDate = purchaseDate, warrantyEndDate = warrantyEndDate)
