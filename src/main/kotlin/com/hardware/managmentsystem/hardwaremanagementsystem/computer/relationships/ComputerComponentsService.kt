package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import com.hardware.managmentsystem.hardwaremanagementsystem.computer.ComputerRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu.CpuRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive.HardDriveRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory.MemoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ComputerComponentsService(
    private val computers: ComputerRepository,
    private val cpus: CpuRepository,
    private val memories: MemoryRepository,
    private val drives: HardDriveRepository,
    private val compCpu: ComputerCpuRepository,
    private val compMemory: ComputerMemoryRepository,
    private val compDrive: ComputerDriveRepository
) {
    
    // CPU Operations
    @Transactional
    fun attachCpu(computerId: UUID, cpuId: UUID): UUID {
        val computer = computers.findById(computerId).orElseThrow { RuntimeException("Computer not found: $computerId") }
        val cpu = cpus.findById(cpuId).orElseThrow { RuntimeException("CPU not found: $cpuId") }
        return compCpu.save(ComputerCpu(computer, cpu)).id!!
    }

    @Transactional
    fun detachCpu(computerId: UUID, cpuId: UUID) {
        val deleted = compCpu.deleteByComputerIdAndCpuId(computerId, cpuId)
        if (deleted == 0L) throw RuntimeException("CPU relationship not found for computer: $computerId and CPU: $cpuId")
    }

    @Transactional(readOnly = true)
    fun getComputerCpus(computerId: UUID): List<ComputerCpuResponse> {
        if (!computers.existsById(computerId)) throw RuntimeException("Computer not found: $computerId")
        return compCpu.findAll()
            .filter { it.computer.id == computerId }
            .map { ComputerCpuResponse(it.id!!, it.computer.id!!, it.cpu.id!!, it.cpu.name) }
    }

    // Memory Operations
    @Transactional
    fun attachMemory(computerId: UUID, memoryId: UUID): UUID {
        val computer = computers.findById(computerId).orElseThrow { RuntimeException("Computer not found: $computerId") }
        val memory = memories.findById(memoryId).orElseThrow { RuntimeException("Memory not found: $memoryId") }
        return compMemory.save(ComputerMemory(computer, memory)).id!!
    }

    @Transactional
    fun detachMemory(computerId: UUID, memoryId: UUID) {
        val deleted = compMemory.deleteByComputerIdAndMemoryId(computerId, memoryId)
        if (deleted == 0L) throw RuntimeException("Memory relationship not found for computer: $computerId and Memory: $memoryId")
    }

    @Transactional(readOnly = true)
    fun getComputerMemories(computerId: UUID): List<ComputerMemoryResponse> {
        if (!computers.existsById(computerId)) throw RuntimeException("Computer not found: $computerId")
        return compMemory.findAll()
            .filter { it.computer.id == computerId }
            .map { ComputerMemoryResponse(it.id!!, it.computer.id!!, it.memory.id!!, it.memory.name) }
    }

    // Drive Operations
    @Transactional
    fun attachDrive(computerId: UUID, driveId: UUID): UUID {
        val computer = computers.findById(computerId).orElseThrow { RuntimeException("Computer not found: $computerId") }
        val drive = drives.findById(driveId).orElseThrow { RuntimeException("Drive not found: $driveId") }
        return compDrive.save(ComputerDrive(computer, drive)).id!!
    }

    @Transactional
    fun detachDrive(computerId: UUID, driveId: UUID) {
        val deleted = compDrive.deleteByComputerIdAndDriveId(computerId, driveId)
        if (deleted == 0L) throw RuntimeException("Drive relationship not found for computer: $computerId and Drive: $driveId")
    }

    @Transactional(readOnly = true)
    fun getComputerDrives(computerId: UUID): List<ComputerDriveResponse> {
        if (!computers.existsById(computerId)) throw RuntimeException("Computer not found: $computerId")
        return compDrive.findAll()
            .filter { it.computer.id == computerId }
            .map { ComputerDriveResponse(it.id!!, it.computer.id!!, it.drive.id!!, it.drive.name) }
    }

    // Get all components for a computer
    @Transactional(readOnly = true)
    fun getComputerComponents(computerId: UUID): ComputerComponentsResponse {
        if (!computers.existsById(computerId)) throw RuntimeException("Computer not found: $computerId")
        
        return ComputerComponentsResponse(
            computerId = computerId,
            cpus = getComputerCpus(computerId),
            memories = getComputerMemories(computerId),
            drives = getComputerDrives(computerId)
        )
    }
}
