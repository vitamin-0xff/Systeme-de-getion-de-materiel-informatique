
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BulkComponentsService(
    private val componentsService: ComputerComponentsService
) {
    
    @Transactional
    fun attachMultipleCpus(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        return request.componentIds.map { cpuId ->
            componentsService.attachCpu(computerId, cpuId)
        }
    }

    @Transactional
    fun detachMultipleCpus(computerId: UUID, request: AttachMultipleComponentsRequest) {
        request.componentIds.forEach { cpuId ->
            componentsService.detachCpu(computerId, cpuId)
        }
    }

    @Transactional
    fun attachMultipleMemories(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        return request.componentIds.map { memoryId ->
            componentsService.attachMemory(computerId, memoryId)
        }
    }

    @Transactional
    fun detachMultipleMemories(computerId: UUID, request: AttachMultipleComponentsRequest) {
        request.componentIds.forEach { memoryId ->
            componentsService.detachMemory(computerId, memoryId)
        }
    }

    @Transactional
    fun attachMultipleDrives(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        return request.componentIds.map { driveId ->
            componentsService.attachDrive(computerId, driveId)
        }
    }

    @Transactional
    fun detachMultipleDrives(computerId: UUID, request: AttachMultipleComponentsRequest) {
        request.componentIds.forEach { driveId ->
            componentsService.detachDrive(computerId, driveId)
        }
    }

    @Transactional
    fun replaceComputerCpus(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        // First detach all existing CPUs
        val existingCpus = componentsService.getComputerCpus(computerId)
        existingCpus.forEach { componentsService.detachCpu(computerId, it.cpuId) }
        
        // Then attach new ones
        return attachMultipleCpus(computerId, request)
    }

    @Transactional
    fun replaceComputerMemories(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        // First detach all existing memories
        val existingMemories = componentsService.getComputerMemories(computerId)
        existingMemories.forEach { componentsService.detachMemory(computerId, it.memoryId) }
        
        // Then attach new ones
        return attachMultipleMemories(computerId, request)
    }

    @Transactional
    fun replaceComputerDrives(computerId: UUID, request: AttachMultipleComponentsRequest): List<UUID> {
        // First detach all existing drives
        val existingDrives = componentsService.getComputerDrives(computerId)
        existingDrives.forEach { componentsService.detachDrive(computerId, it.driveId) }
        
        // Then attach new ones
        return attachMultipleDrives(computerId, request)
    }
}
