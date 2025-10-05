package com.hardware.managmentsystem.hardwaremanagementsystem.computer

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ComputerRepository : JpaRepository<ComputerEntity, UUID> {
    fun findBySerialNumber(serialNumber: String): ComputerEntity?
    fun findByType(type: ComputerType, pageable: Pageable): Page<ComputerEntity>
    fun findByActive(active: Boolean, pageable: Pageable): Page<ComputerEntity>
    fun findByWorking(working: Boolean, pageable: Pageable): Page<ComputerEntity>
    fun findByMarqueId(marqueId: UUID): List<ComputerEntity>

}