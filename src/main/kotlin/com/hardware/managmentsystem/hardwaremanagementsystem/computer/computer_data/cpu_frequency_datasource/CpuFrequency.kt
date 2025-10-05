package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "cpu_generation")
@Entity
data class CpuFrequency(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var label: String,
    var frequency: Float,
    @Enumerated(EnumType.STRING)
    var freqUnit: FreqUnit
)