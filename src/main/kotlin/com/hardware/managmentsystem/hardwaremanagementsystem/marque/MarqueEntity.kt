package com.hardware.managmentsystem.hardwaremanagementsystem.marque

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.MarquesType
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "marques")
class MarqueEntity(
    var label: String,
    var businessNumber: String? = null,
    var imageUrl: String? = null,
    val types: MutableList<MarquesType> = mutableListOf()
) : BaseEntity()