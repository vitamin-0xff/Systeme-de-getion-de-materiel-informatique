package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "memories")
class MemoryEntity(
    var name: String,
    var frequency: Float,
    @Column(name = "size_unit")
    @Enumerated(EnumType.STRING) var sizeUnit: SizeUnit = SizeUnit.GB,
    @Column(name = "freq_unit")
    @Enumerated(EnumType.STRING) var freqUnit: FreqUnit = FreqUnit.GHz,
    var size: Float,
    var type: String,
    @ManyToOne(fetch = FetchType.LAZY) var marque: MarqueEntity? = null,
    @Column(name = "image_url")
    var imageUrl: String? = null
) : BaseEntity()