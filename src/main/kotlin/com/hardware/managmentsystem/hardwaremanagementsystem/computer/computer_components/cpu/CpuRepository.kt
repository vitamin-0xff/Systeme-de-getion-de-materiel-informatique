package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CpuRepository : JpaRepository<CpuEntity, UUID>
