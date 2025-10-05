package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "cpu_generation")
@Entity
data class CpuGeneration(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var label: String,
    var generation: String,
    val features: MutableList<String>
)