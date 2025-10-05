package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "hard_drive_size")
data class HardDriveSize(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var label: String,
    var size: Long,
    var sizeUnit: SizeUnit
)
