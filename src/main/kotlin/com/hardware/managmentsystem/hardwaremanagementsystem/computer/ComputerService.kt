
package com.hardware.managmentsystem.hardwaremanagementsystem.computer

import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.MotherBoardChipsetRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.MotherboardChipsetRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.MotherboardChipsetResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.MotherboardChipsetUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.ComputerTypeRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.ComputerTypeRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.ComputerTypeResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.ComputerTypeUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.CpuFrequencyRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.CpuFrequencyRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.CpuFrequencyResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.CpuFrequencyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.CpuGenerationRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.CpuGenerationRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.CpuGenerationResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.CpuGenerationUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.HardDriveSizeRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.HardDriveSizeRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.HardDriveSizeResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.HardDriveSizeUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.HardDriveTypeRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.HardDriveTypeRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.HardDriveTypeResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.HardDriveTypeUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.MemoryFrequencyRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.MemoryFrequencyRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.MemoryFrequencyResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.MemoryFrequencyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.MemorySizeRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.MemorySizeRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.MemorySizeResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.MemorySizeUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.toResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.MemoryTypeRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.MemoryTypeRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.MemoryTypeResponse
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.MemoryTypeUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.applyUpdate
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.toEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.toResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class ComputerService(
    private val repo: ComputerRepository,
    private val marques: MarqueRepository,
    private val providers: ProviderRepository,
    private val motherboardChipsetRepo: MotherBoardChipsetRepository,
    private val computerTypeRepo: ComputerTypeRepository,
    private val cpuFrequencyRepo: CpuFrequencyRepository,
    private val cpuGenerationRepo: CpuGenerationRepository,
    private val hardDriveSizeRepo: HardDriveSizeRepository,
    private val hardDriveTypeRepo: HardDriveTypeRepository,
    private val memoryFrequencyRepo: MemoryFrequencyRepository,
    private val memorySizeRepo: MemorySizeRepository,
    private val memoryTypeRepo: MemoryTypeRepository
) {
    @Transactional
    fun create(req: ComputerRequest): ComputerResponse {
        val marque = marques.findById(req.marqueId).orElseThrow { RuntimeException("Marque not found: ${req.marqueId}") }
        val provider = req.providerId?.let { providers.findById(it).orElseThrow { RuntimeException("Provider not found: $it") } }
        return repo.save(req.toEntity(marque, provider)).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<ComputerResponse> = repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID): ComputerResponse = repo.findById(id).orElseThrow { RuntimeException("Computer not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: ComputerUpdate): ComputerResponse {
        val entity = repo.findById(id).orElseThrow { RuntimeException("Computer not found: $id") }
        val marque = u.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        val provider = u.providerId?.let { providers.findById(it).orElseThrow { RuntimeException("Provider not found: $it") } }
        entity.applyUpdate(u, marque, provider)
        return repo.save(entity).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Computer not found: $id")
        repo.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun getBySerialNumber(serialNumber: String): ComputerResponse? =
        repo.findBySerialNumber(serialNumber)?.toResponse()

    @Transactional(readOnly = true)
    fun getByType(type: com.hardware.managmentsystem.hardwaremanagementsystem._config.ComputerType, pageable: Pageable): Page<ComputerResponse> =
        repo.findByType(type, pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getActiveComputers(pageable: Pageable): Page<ComputerResponse> =
        repo.findByActive(true, pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getWorkingComputers(pageable: Pageable): Page<ComputerResponse> =
        repo.findByWorking(true, pageable).map { it.toResponse() }

    // ===== Motherboard Chipset CRUD =====
    @Transactional
    fun createMotherboardChipsetData(req: MotherboardChipsetRequest): MotherboardChipsetResponse =
        motherboardChipsetRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listMotherboardChipsetsData(pageable: Pageable): Page<MotherboardChipsetResponse> =
        motherboardChipsetRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getMotherboardChipsetData(id: Long): MotherboardChipsetResponse =
        motherboardChipsetRepo.findById(id).orElseThrow { RuntimeException("Motherboard chipset not found: $id") }.toResponse()

    @Transactional
    fun updateMotherboardChipsetData(id: Long, u: MotherboardChipsetUpdate): MotherboardChipsetResponse {
        val entity = motherboardChipsetRepo.findById(id).orElseThrow { RuntimeException("Motherboard chipset not found: $id") }
        entity.applyUpdate(u)
        return motherboardChipsetRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteMotherboardChipsetData(id: Long) {
        if (!motherboardChipsetRepo.existsById(id)) throw RuntimeException("Motherboard chipset not found: $id")
        motherboardChipsetRepo.deleteById(id)
    }

    // ===== Computer Type CRUD =====
    @Transactional
    fun createComputerTypeData(req: ComputerTypeRequest): ComputerTypeResponse =
        computerTypeRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listComputerTypesData(pageable: Pageable): Page<ComputerTypeResponse> =
        computerTypeRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getComputerTypeData(id: Long): ComputerTypeResponse =
        computerTypeRepo.findById(id).orElseThrow { RuntimeException("Computer type not found: $id") }.toResponse()

    @Transactional
    fun updateComputerTypeData(id: Long, u: ComputerTypeUpdate): ComputerTypeResponse {
        val entity = computerTypeRepo.findById(id).orElseThrow { RuntimeException("Computer type not found: $id") }
        entity.applyUpdate(u)
        return computerTypeRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteComputerTypeData(id: Long) {
        if (!computerTypeRepo.existsById(id)) throw RuntimeException("Computer type not found: $id")
        computerTypeRepo.deleteById(id)
    }

    // ===== CPU Frequency CRUD =====
    @Transactional
    fun createCpuFrequencyData(req: CpuFrequencyRequest): CpuFrequencyResponse =
        cpuFrequencyRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listCpuFrequenciesData(pageable: Pageable): Page<CpuFrequencyResponse> =
        cpuFrequencyRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getCpuFrequencyData(id: Long): CpuFrequencyResponse =
        cpuFrequencyRepo.findById(id).orElseThrow { RuntimeException("CPU frequency not found: $id") }.toResponse()

    @Transactional
    fun updateCpuFrequencyData(id: Long, u: CpuFrequencyUpdate): CpuFrequencyResponse {
        val entity = cpuFrequencyRepo.findById(id).orElseThrow { RuntimeException("CPU frequency not found: $id") }
        entity.applyUpdate(u)
        return cpuFrequencyRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteCpuFrequencyData(id: Long) {
        if (!cpuFrequencyRepo.existsById(id)) throw RuntimeException("CPU frequency not found: $id")
        cpuFrequencyRepo.deleteById(id)
    }

    // ===== CPU Generation CRUD =====
    @Transactional
    fun createCpuGenerationData(req: CpuGenerationRequest): CpuGenerationResponse =
        cpuGenerationRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listCpuGenerationsData(pageable: Pageable): Page<CpuGenerationResponse> =
        cpuGenerationRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getCpuGenerationData(id: Long): CpuGenerationResponse =
        cpuGenerationRepo.findById(id).orElseThrow { RuntimeException("CPU generation not found: $id") }.toResponse()

    @Transactional
    fun updateCpuGenerationData(id: Long, u: CpuGenerationUpdate): CpuGenerationResponse {
        val entity = cpuGenerationRepo.findById(id).orElseThrow { RuntimeException("CPU generation not found: $id") }
        entity.applyUpdate(u)
        return cpuGenerationRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteCpuGenerationData(id: Long) {
        if (!cpuGenerationRepo.existsById(id)) throw RuntimeException("CPU generation not found: $id")
        cpuGenerationRepo.deleteById(id)
    }

    // ===== Hard Drive Size CRUD =====
    @Transactional
    fun createHardDriveSizeData(req: HardDriveSizeRequest): HardDriveSizeResponse =
        hardDriveSizeRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listHardDriveSizesData(pageable: Pageable): Page<HardDriveSizeResponse> =
        hardDriveSizeRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getHardDriveSizeData(id: Long): HardDriveSizeResponse =
        hardDriveSizeRepo.findById(id).orElseThrow { RuntimeException("Hard drive size not found: $id") }.toResponse()

    @Transactional
    fun updateHardDriveSizeData(id: Long, u: HardDriveSizeUpdate): HardDriveSizeResponse {
        val entity = hardDriveSizeRepo.findById(id).orElseThrow { RuntimeException("Hard drive size not found: $id") }
        entity.applyUpdate(u)
        return hardDriveSizeRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteHardDriveSizeData(id: Long) {
        if (!hardDriveSizeRepo.existsById(id)) throw RuntimeException("Hard drive size not found: $id")
        hardDriveSizeRepo.deleteById(id)
    }

    // ===== Hard Drive Type CRUD =====
    @Transactional
    fun createHardDriveTypeData(req: HardDriveTypeRequest): HardDriveTypeResponse =
        hardDriveTypeRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listHardDriveTypesData(pageable: Pageable): Page<HardDriveTypeResponse> =
        hardDriveTypeRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getHardDriveTypeData(id: Long): HardDriveTypeResponse =
        hardDriveTypeRepo.findById(id).orElseThrow { RuntimeException("Hard drive type not found: $id") }.toResponse()

    @Transactional
    fun updateHardDriveTypeData(id: Long, u: HardDriveTypeUpdate): HardDriveTypeResponse {
        val entity = hardDriveTypeRepo.findById(id).orElseThrow { RuntimeException("Hard drive type not found: $id") }
        entity.applyUpdate(u)
        return hardDriveTypeRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteHardDriveTypeData(id: Long) {
        if (!hardDriveTypeRepo.existsById(id)) throw RuntimeException("Hard drive type not found: $id")
        hardDriveTypeRepo.deleteById(id)
    }

    // ===== Memory Frequency CRUD =====
    @Transactional
    fun createMemoryFrequencyData(req: MemoryFrequencyRequest): MemoryFrequencyResponse =
        memoryFrequencyRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listMemoryFrequenciesData(pageable: Pageable): Page<MemoryFrequencyResponse> =
        memoryFrequencyRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getMemoryFrequencyData(id: Long): MemoryFrequencyResponse =
        memoryFrequencyRepo.findById(id).orElseThrow { RuntimeException("Memory frequency not found: $id") }.toResponse()

    @Transactional
    fun updateMemoryFrequencyData(id: Long, u: MemoryFrequencyUpdate): MemoryFrequencyResponse {
        val entity = memoryFrequencyRepo.findById(id).orElseThrow { RuntimeException("Memory frequency not found: $id") }
        entity.applyUpdate(u)
        return memoryFrequencyRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteMemoryFrequencyData(id: Long) {
        if (!memoryFrequencyRepo.existsById(id)) throw RuntimeException("Memory frequency not found: $id")
        memoryFrequencyRepo.deleteById(id)
    }

    // ===== Memory Size CRUD =====
    @Transactional
    fun createMemorySizeData(req: MemorySizeRequest): MemorySizeResponse =
        memorySizeRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listMemorySizesData(pageable: Pageable): Page<MemorySizeResponse> =
        memorySizeRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getMemorySizeData(id: Long): MemorySizeResponse =
        memorySizeRepo.findById(id).orElseThrow { RuntimeException("Memory size not found: $id") }.toResponse()

    @Transactional
    fun updateMemorySizeData(id: Long, u: MemorySizeUpdate): MemorySizeResponse {
        val entity = memorySizeRepo.findById(id).orElseThrow { RuntimeException("Memory size not found: $id") }
        entity.applyUpdate(u)
        return memorySizeRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteMemorySizeData(id: Long) {
        if (!memorySizeRepo.existsById(id)) throw RuntimeException("Memory size not found: $id")
        memorySizeRepo.deleteById(id)
    }

    // ===== Memory Type CRUD =====
    @Transactional
    fun createMemoryTypeData(req: MemoryTypeRequest): MemoryTypeResponse =
        memoryTypeRepo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun listMemoryTypesData(pageable: Pageable): Page<MemoryTypeResponse> =
        memoryTypeRepo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun getMemoryTypeData(id: Long): MemoryTypeResponse =
        memoryTypeRepo.findById(id).orElseThrow { RuntimeException("Memory type not found: $id") }.toResponse()

    @Transactional
    fun updateMemoryTypeData(id: Long, u: MemoryTypeUpdate): MemoryTypeResponse {
        val entity = memoryTypeRepo.findById(id).orElseThrow { RuntimeException("Memory type not found: $id") }
        entity.applyUpdate(u)
        return memoryTypeRepo.save(entity).toResponse()
    }

    @Transactional
    fun deleteMemoryTypeData(id: Long) {
        if (!memoryTypeRepo.existsById(id)) throw RuntimeException("Memory type not found: $id")
        memoryTypeRepo.deleteById(id)
    }
}
