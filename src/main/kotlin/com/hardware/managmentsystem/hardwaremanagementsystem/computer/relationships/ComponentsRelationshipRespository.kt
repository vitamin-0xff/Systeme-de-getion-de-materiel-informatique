package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ComputerCpuRepository : JpaRepository<ComputerCpu, UUID> {
    fun deleteByComputerIdAndCpuId(computerId: UUID, cpuId: UUID): Long
}
@Repository
interface ComputerMemoryRepository : JpaRepository<ComputerMemory, UUID> {
    fun deleteByComputerIdAndMemoryId(computerId: UUID, memoryId: UUID): Long
}
@Repository
interface ComputerDriveRepository : JpaRepository<ComputerDrive, UUID> {
    fun deleteByComputerIdAndDriveId(computerId: UUID, driveId: UUID): Long
}