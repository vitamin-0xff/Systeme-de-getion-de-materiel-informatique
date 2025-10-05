package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "cpus")
class CpuEntity(
    var name: String,
    var frequency: Float,
    @Column(name = "freq_unit")
    @Enumerated(EnumType.STRING) var freqUnit: FreqUnit = FreqUnit.GHz,
    var generation: String,
    @Column(name = "cache_size")
    var cacheSize: String,
    @Column(name = "number_cores")
    var numberCores: Int,
    var socket: String? = null,
    @ManyToOne(fetch = FetchType.LAZY) var marque: MarqueEntity? = null,
    @Column(name = "image_uri")
    var imageUrl: String? = null
) : BaseEntity()
