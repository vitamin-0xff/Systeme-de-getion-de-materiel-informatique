package com.hardware.managmentsystem.hardwaremanagementsystem.provider

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProviderRepository : JpaRepository<ProviderEntity, UUID> {
    fun findByNameContainingIgnoreCase(name: String, pageable: Pageable): Page<ProviderEntity>
    fun findByBusinessNumber(businessNumber: String): ProviderEntity?
}