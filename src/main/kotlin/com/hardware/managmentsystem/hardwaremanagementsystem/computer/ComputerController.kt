package com.hardware.managmentsystem.hardwaremanagementsystem.computer

import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.FilterAppliedRequest
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.FilterCountModel
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.FilterCountService
import com.hardware.managmentsystem.hardwaremanagementsystem._core.filter.ModelMetadata
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/computers")
class ComputerController(private val service: ComputerService, private val filterService: FilterCountService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ComputerRequest): ComputerResponse =
        service.create(request)

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAll(@RequestBody request: List<ComputerRequest>): List<ComputerResponse> {
        val listOfNewComputers = mutableListOf<ComputerResponse>()
        for (computer in request) {
            listOfNewComputers.add(service.create(computer))
        }
        return listOfNewComputers
    }


    @GetMapping
    fun list(
        @PageableDefault(size = 20) pageable: Pageable,
        @RequestParam(required = false) type: ComputerType?,
        @RequestParam(required = false) active: Boolean?,
        @RequestParam(required = false) working: Boolean?
    ): Page<ComputerResponse> = when {
        type != null -> service.getByType(type, pageable)
        active == true -> service.getActiveComputers(pageable)
        working == true -> service.getWorkingComputers(pageable)
        else -> service.list(pageable)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): ComputerResponse =
        service.get(id)

    @GetMapping("/serial/{serialNumber}")
    fun getBySerial(@PathVariable serialNumber: String): ComputerResponse =
        service.getBySerialNumber(serialNumber) ?: throw RuntimeException("Computer not found with serial: $serialNumber")

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: ComputerUpdate): ComputerResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)

    // ===== Motherboard Chipset Endpoints =====
    @PostMapping("/data/motherboard-chipsets")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMotherboardChipset(@RequestBody request: MotherboardChipsetRequest): MotherboardChipsetResponse =
        service.createMotherboardChipsetData(request)

    @GetMapping("/data/motherboard-chipsets")
    fun listMotherboardChipsets(pageable: Pageable = Pageable.ofSize(20)): Page<MotherboardChipsetResponse> =
        service.listMotherboardChipsetsData(pageable)

    @GetMapping("/data/motherboard-chipsets/{id}")
    fun getMotherboardChipset(@PathVariable id: Long): MotherboardChipsetResponse =
        service.getMotherboardChipsetData(id)

    @PutMapping("/data/motherboard-chipsets/{id}")
    fun updateMotherboardChipset(@PathVariable id: Long, @RequestBody update: MotherboardChipsetUpdate): MotherboardChipsetResponse =
        service.updateMotherboardChipsetData(id, update)

    @DeleteMapping("/data/motherboard-chipsets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMotherboardChipset(@PathVariable id: Long) =
        service.deleteMotherboardChipsetData(id)

    // ===== Computer Type Endpoints =====
    @PostMapping("/data/computer-types")
    @ResponseStatus(HttpStatus.CREATED)
    fun createComputerType(@RequestBody request: ComputerTypeRequest): ComputerTypeResponse =
        service.createComputerTypeData(request)

    @GetMapping("/data/computer-types")
    fun listComputerTypes(pageable: Pageable = Pageable.ofSize(20)): Page<ComputerTypeResponse> =
        service.listComputerTypesData(pageable)

    @GetMapping("/data/computer-types/{id}")
    fun getComputerType(@PathVariable id: Long): ComputerTypeResponse =
        service.getComputerTypeData(id)

    @PutMapping("/data/computer-types/{id}")
    fun updateComputerType(@PathVariable id: Long, @RequestBody update: ComputerTypeUpdate): ComputerTypeResponse =
        service.updateComputerTypeData(id, update)

    @DeleteMapping("/data/computer-types/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteComputerType(@PathVariable id: Long) =
        service.deleteComputerTypeData(id)

    // ===== CPU Frequency Endpoints =====
    @PostMapping("/data/cpu-frequencies")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCpuFrequency(@RequestBody request: CpuFrequencyRequest): CpuFrequencyResponse =
        service.createCpuFrequencyData(request)

    @GetMapping("/data/cpu-frequencies")
    fun listCpuFrequencies(pageable: Pageable = Pageable.ofSize(20)): Page<CpuFrequencyResponse> =
        service.listCpuFrequenciesData(pageable)

    @GetMapping("/data/cpu-frequencies/{id}")
    fun getCpuFrequency(@PathVariable id: Long): CpuFrequencyResponse =
        service.getCpuFrequencyData(id)

    @PutMapping("/data/cpu-frequencies/{id}")
    fun updateCpuFrequency(@PathVariable id: Long, @RequestBody update: CpuFrequencyUpdate): CpuFrequencyResponse =
        service.updateCpuFrequencyData(id, update)

    @DeleteMapping("/data/cpu-frequencies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCpuFrequency(@PathVariable id: Long) =
        service.deleteCpuFrequencyData(id)

    // ===== CPU Generation Endpoints =====
    @PostMapping("/data/cpu-generations")
    @ResponseStatus(HttpStatus.CREATED)
    fun createCpuGeneration(@RequestBody request: CpuGenerationRequest): CpuGenerationResponse =
        service.createCpuGenerationData(request)

    @GetMapping("/data/cpu-generations")
    fun listCpuGenerations(pageable: Pageable = Pageable.ofSize(20)): Page<CpuGenerationResponse> =
        service.listCpuGenerationsData(pageable)

    @GetMapping("/data/cpu-generations/{id}")
    fun getCpuGeneration(@PathVariable id: Long): CpuGenerationResponse =
        service.getCpuGenerationData(id)

    @PutMapping("/data/cpu-generations/{id}")
    fun updateCpuGeneration(@PathVariable id: Long, @RequestBody update: CpuGenerationUpdate): CpuGenerationResponse =
        service.updateCpuGenerationData(id, update)

    @DeleteMapping("/data/cpu-generations/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCpuGeneration(@PathVariable id: Long) =
        service.deleteCpuGenerationData(id)

    // ===== Hard Drive Size Endpoints =====
    @PostMapping("/data/hard-drive-sizes")
    @ResponseStatus(HttpStatus.CREATED)
    fun createHardDriveSize(@RequestBody request: HardDriveSizeRequest): HardDriveSizeResponse =
        service.createHardDriveSizeData(request)

    @GetMapping("/data/hard-drive-sizes")
    fun listHardDriveSizes(pageable: Pageable = Pageable.ofSize(20)): Page<HardDriveSizeResponse> =
        service.listHardDriveSizesData(pageable)

    @GetMapping("/data/hard-drive-sizes/{id}")
    fun getHardDriveSize(@PathVariable id: Long): HardDriveSizeResponse =
        service.getHardDriveSizeData(id)

    @PutMapping("/data/hard-drive-sizes/{id}")
    fun updateHardDriveSize(@PathVariable id: Long, @RequestBody update: HardDriveSizeUpdate): HardDriveSizeResponse =
        service.updateHardDriveSizeData(id, update)

    @DeleteMapping("/data/hard-drive-sizes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteHardDriveSize(@PathVariable id: Long) =
        service.deleteHardDriveSizeData(id)

    // ===== Hard Drive Type Endpoints =====
    @PostMapping("/data/hard-drive-types")
    @ResponseStatus(HttpStatus.CREATED)
    fun createHardDriveType(@RequestBody request: HardDriveTypeRequest): HardDriveTypeResponse =
        service.createHardDriveTypeData(request)

    @GetMapping("/data/hard-drive-types")
    fun listHardDriveTypes(pageable: Pageable = Pageable.ofSize(20)): Page<HardDriveTypeResponse> =
        service.listHardDriveTypesData(pageable)

    @GetMapping("/data/hard-drive-types/{id}")
    fun getHardDriveType(@PathVariable id: Long): HardDriveTypeResponse =
        service.getHardDriveTypeData(id)

    @PutMapping("/data/hard-drive-types/{id}")
    fun updateHardDriveType(@PathVariable id: Long, @RequestBody update: HardDriveTypeUpdate): HardDriveTypeResponse =
        service.updateHardDriveTypeData(id, update)

    @DeleteMapping("/data/hard-drive-types/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteHardDriveType(@PathVariable id: Long) =
        service.deleteHardDriveTypeData(id)

    // ===== Memory Frequency Endpoints =====
    @PostMapping("/data/memory-frequencies")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMemoryFrequency(@RequestBody request: MemoryFrequencyRequest): MemoryFrequencyResponse =
        service.createMemoryFrequencyData(request)

    @GetMapping("/data/memory-frequencies")
    fun listMemoryFrequencies(pageable: Pageable = Pageable.ofSize(20)): Page<MemoryFrequencyResponse> =
        service.listMemoryFrequenciesData(pageable)

    @GetMapping("/data/memory-frequencies/{id}")
    fun getMemoryFrequency(@PathVariable id: Long): MemoryFrequencyResponse =
        service.getMemoryFrequencyData(id)

    @PutMapping("/data/memory-frequencies/{id}")
    fun updateMemoryFrequency(@PathVariable id: Long, @RequestBody update: MemoryFrequencyUpdate): MemoryFrequencyResponse =
        service.updateMemoryFrequencyData(id, update)

    @DeleteMapping("/data/memory-frequencies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMemoryFrequency(@PathVariable id: Long) =
        service.deleteMemoryFrequencyData(id)

    // ===== Memory Size Endpoints =====
    @PostMapping("/data/memory-sizes")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMemorySize(@RequestBody request: MemorySizeRequest): MemorySizeResponse =
        service.createMemorySizeData(request)

    @GetMapping("/data/memory-sizes")
    fun listMemorySizes(pageable: Pageable = Pageable.ofSize(20)): Page<MemorySizeResponse> =
        service.listMemorySizesData(pageable)

    @GetMapping("/data/memory-sizes/{id}")
    fun getMemorySize(@PathVariable id: Long): MemorySizeResponse =
        service.getMemorySizeData(id)

    @PutMapping("/data/memory-sizes/{id}")
    fun updateMemorySize(@PathVariable id: Long, @RequestBody update: MemorySizeUpdate): MemorySizeResponse =
        service.updateMemorySizeData(id, update)

    @DeleteMapping("/data/memory-sizes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMemorySize(@PathVariable id: Long) =
        service.deleteMemorySizeData(id)

    // ===== Memory Type Endpoints =====
    @PostMapping("/data/memory-types")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMemoryType(@RequestBody request: MemoryTypeRequest): MemoryTypeResponse =
        service.createMemoryTypeData(request)

    @GetMapping("/data/memory-types")
    fun listMemoryTypes(pageable: Pageable = Pageable.ofSize(20)): Page<MemoryTypeResponse> =
        service.listMemoryTypesData(pageable)

    @GetMapping("/data/memory-types/{id}")
    fun getMemoryType(@PathVariable id: Long): MemoryTypeResponse =
        service.getMemoryTypeData(id)

    @PutMapping("/data/memory-types/{id}")
    fun updateMemoryType(@PathVariable id: Long, @RequestBody update: MemoryTypeUpdate): MemoryTypeResponse =
        service.updateMemoryTypeData(id, update)

    @DeleteMapping("/data/memory-types/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteMemoryType(@PathVariable id: Long) =
        service.deleteMemoryTypeData(id)

    // filter callbacks

    @PostMapping("/filter/attributes-count")
    fun getFilterAttributesCount(@RequestBody filterAppliedRequest: FilterAppliedRequest = FilterAppliedRequest("Computer", "computer", emptyList())): FilterCountModel {
        return filterService.getAttributesCount(
            filterAppliedRequest,
            ComputerEntity::class.java,
            attributesMetadata = DefaultAttributesOfComputer.defaultAttributesOfComputerMetaData,
            ModelMetadata(modelCode = "computer", modelName = "Computer"))
    }
}
