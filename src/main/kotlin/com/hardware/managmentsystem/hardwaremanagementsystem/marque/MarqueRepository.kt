package com.hardware.managmentsystem.hardwaremanagementsystem.marque

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MarqueRepository : JpaRepository<MarqueEntity, UUID> {
    fun findByLabelContainingIgnoreCase(q: String, pageable: Pageable): Page<MarqueEntity>
}