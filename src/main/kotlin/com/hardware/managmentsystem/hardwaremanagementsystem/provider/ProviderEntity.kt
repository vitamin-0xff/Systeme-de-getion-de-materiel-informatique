package com.hardware.managmentsystem.hardwaremanagementsystem.provider

import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "providers")
class ProviderEntity(
    var name: String,
    var email: String? = null,
    var phoneNumber: String? = null,
    var businessNumber: String? = null,
    var imageUrl: String? = null,
    var businessName: String? = null,
    var businessId: String? = null
) : BaseEntity()
