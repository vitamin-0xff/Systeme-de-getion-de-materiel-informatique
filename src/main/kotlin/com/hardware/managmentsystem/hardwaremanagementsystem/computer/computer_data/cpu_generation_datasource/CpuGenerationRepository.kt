package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CpuGenerationRepository: JpaRepository<CpuGeneration, Long>