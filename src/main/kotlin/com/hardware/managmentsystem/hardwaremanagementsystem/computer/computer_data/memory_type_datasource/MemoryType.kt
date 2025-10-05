package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "memory_type")
data class MemoryType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var label: String,
    val features: MutableList<String>
)
