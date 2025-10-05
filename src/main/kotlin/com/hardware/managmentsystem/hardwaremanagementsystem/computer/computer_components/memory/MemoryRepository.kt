package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MemoryRepository : JpaRepository<MemoryEntity, UUID>
