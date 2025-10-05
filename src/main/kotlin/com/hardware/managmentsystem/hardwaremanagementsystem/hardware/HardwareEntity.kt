package com.hardware.managmentsystem.hardwaremanagementsystem.hardware

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.HardwareStatus
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderEntity
import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorColumn
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "hardware")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dt_hardware")
class HardwareEntity(
    @ManyToOne(fetch = FetchType.LAZY) val marque: MarqueEntity,
    var active: Boolean = true,
    @Enumerated(EnumType.STRING) var status: HardwareStatus = HardwareStatus.WORKING,
    @Column(unique = true) var serialNumber: String,
    var purchaseDate: LocalDate? = null,
    var warrantyEndDate: LocalDate? = null,
    @ManyToOne(fetch = FetchType.LAZY) var provider: ProviderEntity? = null
) : BaseEntity()