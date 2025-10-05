package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
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
@Table(name = "hard_drives")
class HardDriveEntity(
    var name: String,
    var type: String,
    var size: Long,
    @Column(name = "size_unit")
    @Enumerated(EnumType.STRING) var sizeUnit: SizeUnit = SizeUnit.GB,
    @Column(name = "is_ssid")
    var isSsd: Boolean = true,
    @ManyToOne(fetch = FetchType.LAZY) var marque: MarqueEntity? = null,
    @Column(name = "image_url")
    var imageUrl: String? = null
) : BaseEntity()