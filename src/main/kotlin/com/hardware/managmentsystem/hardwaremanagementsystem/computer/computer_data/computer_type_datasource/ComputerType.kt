package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "computer_type")
data class ComputerType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var label: String,
    val features: MutableList<String>
)