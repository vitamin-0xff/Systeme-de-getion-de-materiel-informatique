package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "motherboard_chipset")
@Entity
data class MotherboardChipset(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    var label: String,
    var features: MutableList<String>
)