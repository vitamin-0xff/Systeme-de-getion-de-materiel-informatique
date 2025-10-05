package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "hard_drive_type")
data class HardDriveType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var label: String,
    val features: MutableList<String>
)
