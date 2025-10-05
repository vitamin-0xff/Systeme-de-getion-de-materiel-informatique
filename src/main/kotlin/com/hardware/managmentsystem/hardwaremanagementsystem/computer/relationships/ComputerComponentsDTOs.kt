package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import java.util.*

// Response DTOs
data class ComputerCpuResponse(
    val id: UUID,
    val computerId: UUID,
    val cpuId: UUID,
    val cpuName: String
)

data class ComputerMemoryResponse(
    val id: UUID,
    val computerId: UUID,
    val memoryId: UUID,
    val memoryName: String
)

data class ComputerDriveResponse(
    val id: UUID,
    val computerId: UUID,
    val driveId: UUID,
    val driveName: String
)

data class ComputerComponentsResponse(
    val computerId: UUID,
    val cpus: List<ComputerCpuResponse>,
    val memories: List<ComputerMemoryResponse>,
    val drives: List<ComputerDriveResponse>
)

// Request DTOs for bulk operations
data class AttachComponentRequest(
    val componentId: UUID
)

data class AttachMultipleComponentsRequest(
    val componentIds: List<UUID>
)

// Mappers for entities to responses
fun ComputerCpu.toResponse() = ComputerCpuResponse(
    id = id!!,
    computerId = computer.id!!,
    cpuId = cpu.id!!,
    cpuName = cpu.name
)

fun ComputerMemory.toResponse() = ComputerMemoryResponse(
    id = id!!,
    computerId = computer.id!!,
    memoryId = memory.id!!,
    memoryName = memory.name
)

fun ComputerDrive.toResponse() = ComputerDriveResponse(
    id = id!!,
    computerId = computer.id!!,
    driveId = drive.id!!,
    driveName = drive.name
)
