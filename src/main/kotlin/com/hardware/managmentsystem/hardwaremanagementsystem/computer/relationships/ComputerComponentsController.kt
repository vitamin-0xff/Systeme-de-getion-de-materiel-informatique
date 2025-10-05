package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/computers/{computerId}/components")
class ComputerComponentsController(
    private val componentsService: ComputerComponentsService,
    private val bulkService: BulkComponentsService
) {

    // Get all components for a computer
    @GetMapping
    fun getComputerComponents(@PathVariable computerId: UUID): ComputerComponentsResponse =
        componentsService.getComputerComponents(computerId)

    // CPU endpoints
    @PostMapping("/cpus/{cpuId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachCpu(@PathVariable computerId: UUID, @PathVariable cpuId: UUID): Map<String, UUID> =
        mapOf("id" to componentsService.attachCpu(computerId, cpuId))

    @DeleteMapping("/cpus/{cpuId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachCpu(@PathVariable computerId: UUID, @PathVariable cpuId: UUID) =
        componentsService.detachCpu(computerId, cpuId)

    @GetMapping("/cpus")
    fun getComputerCpus(@PathVariable computerId: UUID): List<ComputerCpuResponse> =
        componentsService.getComputerCpus(computerId)

    @PostMapping("/cpus/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachMultipleCpus(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.attachMultipleCpus(computerId, request)

    @DeleteMapping("/cpus/bulk")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachMultipleCpus(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ) = bulkService.detachMultipleCpus(computerId, request)

    @PutMapping("/cpus/bulk")
    fun replaceComputerCpus(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.replaceComputerCpus(computerId, request)

    // Memory endpoints
    @PostMapping("/memories/{memoryId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachMemory(@PathVariable computerId: UUID, @PathVariable memoryId: UUID): Map<String, UUID> =
        mapOf("id" to componentsService.attachMemory(computerId, memoryId))

    @DeleteMapping("/memories/{memoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachMemory(@PathVariable computerId: UUID, @PathVariable memoryId: UUID) =
        componentsService.detachMemory(computerId, memoryId)

    @GetMapping("/memories")
    fun getComputerMemories(@PathVariable computerId: UUID): List<ComputerMemoryResponse> =
        componentsService.getComputerMemories(computerId)

    @PostMapping("/memories/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachMultipleMemories(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.attachMultipleMemories(computerId, request)

    @DeleteMapping("/memories/bulk")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachMultipleMemories(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ) = bulkService.detachMultipleMemories(computerId, request)

    @PutMapping("/memories/bulk")
    fun replaceComputerMemories(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.replaceComputerMemories(computerId, request)

    // Drive endpoints
    @PostMapping("/drives/{driveId}")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachDrive(@PathVariable computerId: UUID, @PathVariable driveId: UUID): Map<String, UUID> =
        mapOf("id" to componentsService.attachDrive(computerId, driveId))

    @DeleteMapping("/drives/{driveId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachDrive(@PathVariable computerId: UUID, @PathVariable driveId: UUID) =
        componentsService.detachDrive(computerId, driveId)

    @GetMapping("/drives")
    fun getComputerDrives(@PathVariable computerId: UUID): List<ComputerDriveResponse> =
        componentsService.getComputerDrives(computerId)

    @PostMapping("/drives/bulk")
    @ResponseStatus(HttpStatus.CREATED)
    fun attachMultipleDrives(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.attachMultipleDrives(computerId, request)

    @DeleteMapping("/drives/bulk")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun detachMultipleDrives(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ) = bulkService.detachMultipleDrives(computerId, request)

    @PutMapping("/drives/bulk")
    fun replaceComputerDrives(
        @PathVariable computerId: UUID,
         @RequestBody request: AttachMultipleComponentsRequest
    ): List<UUID> = bulkService.replaceComputerDrives(computerId, request)
}
