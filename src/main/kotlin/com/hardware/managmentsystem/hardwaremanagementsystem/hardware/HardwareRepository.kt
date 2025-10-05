package com.hardware.managmentsystem.hardwaremanagementsystem.hardware

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem._config.HardwareStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.UUID

@Repository
interface HardwareRepository : JpaRepository<HardwareEntity, UUID> {
    fun findBySerialNumber(sn: String): HardwareEntity?
    fun findByStatus(status: HardwareStatus, pageable: Pageable): Page<HardwareEntity>
    fun findByMarqueId(marqueId: UUID): List<HardwareEntity>
    @Query("select h from HardwareEntity h where h.purchaseDate between :from and :to")
    fun findPurchasedBetween(from: LocalDate, to: LocalDate): List<HardwareEntity>
}