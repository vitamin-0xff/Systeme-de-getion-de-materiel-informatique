package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "memory_size")
data class MemorySize(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var label: String,
    var size: Long,
    var sizeUnit: SizeUnit
)
