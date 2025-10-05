package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemoryTypeRepository: JpaRepository<MemoryType, Long>