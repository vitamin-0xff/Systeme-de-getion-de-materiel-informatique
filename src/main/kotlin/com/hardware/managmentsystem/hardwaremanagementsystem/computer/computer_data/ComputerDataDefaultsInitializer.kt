
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data

import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource.*
import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Component
class ComputerDataDefaultsInitializer(
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

    fun insertDefaultMotherboardChipsets() {
        if (motherboardChipsetRepo.count() > 0) return

        val defaults = listOf(
            MotherboardChipset(null, "Intel Z790", mutableListOf("DDR5 Support", "PCIe 5.0", "Overclocking")),
            MotherboardChipset( null, "Intel B760", mutableListOf("DDR5 Support", "PCIe 4.0", "Mid-range")),
            MotherboardChipset(null, "Intel H610", mutableListOf("DDR4 Support", "PCIe 3.0", "Budget")),
            MotherboardChipset(null, "AMD X670E", mutableListOf("DDR5 Support", "PCIe 5.0", "Overclocking", "USB 4.0")),
            MotherboardChipset(null, "AMD B650", mutableListOf("DDR5 Support", "PCIe 4.0", "Mid-range")),
            MotherboardChipset(null, "AMD A620", mutableListOf("DDR5 Support", "PCIe 4.0", "Budget")),
            MotherboardChipset(null, "Intel X299", mutableListOf("HEDT", "Quad Channel RAM", "Many PCIe lanes")),
            MotherboardChipset(null, "AMD TRX40", mutableListOf("Threadripper", "Quad Channel RAM", "PCIe 4.0"))
        )
        motherboardChipsetRepo.saveAll(defaults)
    }

    fun insertDefaultComputerTypes() {
        if (computerTypeRepo.count() > 0) return

        val defaults = listOf(
            ComputerType(null, "Desktop PC", mutableListOf("Personal Use", "Gaming", "Office Work")),
            ComputerType(null, "Workstation", mutableListOf("Professional", "High Performance", "Content Creation")),
            ComputerType(null, "Server", mutableListOf("24/7 Operation", "Remote Access", "High Reliability")),
            ComputerType(null, "Home Server", mutableListOf("NAS", "Media Server", "Low Power")),
            ComputerType(null, "HTPC", mutableListOf("Media Center", "Compact", "Silent"))
        )
        computerTypeRepo.saveAll(defaults)
    }

    fun insertDefaultCpuFrequencies() {
        if (cpuFrequencyRepo.count() > 0) return

        val defaults = listOf(
            CpuFrequency(null, "2.0 GHz", 2.0f, FreqUnit.GHz),
            CpuFrequency(null, "2.5 GHz", 2.5f, FreqUnit.GHz),
            CpuFrequency(null, "3.0 GHz", 3.0f, FreqUnit.GHz),
            CpuFrequency(null, "3.5 GHz", 3.5f, FreqUnit.GHz),
            CpuFrequency(null, "4.0 GHz", 4.0f, FreqUnit.GHz),
            CpuFrequency(null, "4.5 GHz", 4.5f, FreqUnit.GHz),
            CpuFrequency(null, "5.0 GHz", 5.0f, FreqUnit.GHz),
            CpuFrequency(null, "5.5 GHz", 5.5f, FreqUnit.GHz),
            CpuFrequency(null, "6.0 GHz", 6.0f, FreqUnit.GHz)
        )
        cpuFrequencyRepo.saveAll(defaults)
    }

    fun insertDefaultCpuGenerations() {
        if (cpuGenerationRepo.count() > 0) return

        val defaults = listOf(
            // Intel
            CpuGeneration(null, "Intel 13th Gen", "13", mutableListOf("Raptor Lake", "Hybrid Architecture", "DDR5")),
            CpuGeneration(null, "Intel 12th Gen", "12", mutableListOf("Alder Lake", "Hybrid Architecture", "DDR4/DDR5")),
            CpuGeneration(null, "Intel 11th Gen", "11", mutableListOf("Rocket Lake", "PCIe 4.0")),
            CpuGeneration(null, "Intel 10th Gen", "10", mutableListOf("Comet Lake", "14nm")),
            CpuGeneration(null, "Intel 14th Gen", "14", mutableListOf("Raptor Lake Refresh", "Hybrid Architecture", "DDR5")),
            // AMD
            CpuGeneration(null, "AMD Ryzen 7000", "7000", mutableListOf("Zen 4", "DDR5", "AM5 Socket")),
            CpuGeneration(null, "AMD Ryzen 5000", "5000", mutableListOf("Zen 3", "DDR4", "AM4 Socket")),
            CpuGeneration(null, "AMD Ryzen 3000", "3000", mutableListOf("Zen 2", "DDR4", "PCIe 4.0")),
            CpuGeneration(null, "AMD Ryzen 2000", "2000", mutableListOf("Zen+", "DDR4"))
        )
        cpuGenerationRepo.saveAll(defaults)
    }

    fun insertDefaultHardDriveSizes() {
        if (hardDriveSizeRepo.count() > 0) return

        val defaults = listOf(
            HardDriveSize(null, "128 GB", 128, SizeUnit.GB),
            HardDriveSize(null, "256 GB", 256, SizeUnit.GB),
            HardDriveSize(null, "512 GB", 512, SizeUnit.GB),
            HardDriveSize(null, "1 TB", 1, SizeUnit.TB),
            HardDriveSize(null, "2 TB", 2, SizeUnit.TB),
            HardDriveSize(null, "4 TB", 4, SizeUnit.TB),
            HardDriveSize(null, "6 TB", 6, SizeUnit.TB),
            HardDriveSize(null, "8 TB", 8, SizeUnit.TB),
            HardDriveSize(null, "10 TB", 10, SizeUnit.TB),
            HardDriveSize(null, "12 TB", 12, SizeUnit.TB),
            HardDriveSize(null, "16 TB", 16, SizeUnit.TB),
            HardDriveSize(null, "20 TB", 20, SizeUnit.TB)
        )
        hardDriveSizeRepo.saveAll(defaults)
    }

    fun insertDefaultHardDriveTypes() {
        if (hardDriveTypeRepo.count() > 0) return

        val defaults = listOf(
            HardDriveType(null, "SATA SSD", mutableListOf("2.5 inch", "Up to 600 MB/s", "Common")),
            HardDriveType(null, "NVMe SSD", mutableListOf("M.2 Form Factor", "High Speed", "PCIe Interface")),
            HardDriveType(null, "NVMe Gen 3", mutableListOf("Up to 3500 MB/s", "PCIe 3.0")),
            HardDriveType(null, "NVMe Gen 4", mutableListOf("Up to 7000 MB/s", "PCIe 4.0")),
            HardDriveType(null, "NVMe Gen 5", mutableListOf("Up to 14000 MB/s", "PCIe 5.0")),
            HardDriveType(null, "SATA HDD", mutableListOf("3.5 inch", "5400/7200 RPM", "Mass Storage")),
            HardDriveType(null, "External SSD", mutableListOf("Portable", "USB 3.0/3.1", "Backup")),
            HardDriveType(null, "External HDD", mutableListOf("Portable", "USB", "Large Capacity"))
        )
        hardDriveTypeRepo.saveAll(defaults)
    }

    fun insertDefaultMemoryFrequencies() {
        if (memoryFrequencyRepo.count() > 0) return

        val defaults = listOf(
            // DDR4
            MemoryFrequency(null, "DDR4-2133", 2133f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-2400", 2400f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-2666", 2666f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-3000", 3000f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-3200", 3200f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-3600", 3600f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR4-4000", 4000f, FreqUnit.MHz),
            // DDR5
            MemoryFrequency(null, "DDR5-4800", 4800f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-5200", 5200f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-5600", 5600f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-6000", 6000f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-6400", 6400f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-7200", 7200f, FreqUnit.MHz),
            MemoryFrequency(null, "DDR5-8000", 8000f, FreqUnit.MHz)
        )
        memoryFrequencyRepo.saveAll(defaults)
    }

    fun insertDefaultMemorySizes() {
        if (memorySizeRepo.count() > 0) return

        val defaults = listOf(
            MemorySize(0L, "4 GB", 4, SizeUnit.GB),
            MemorySize(0L, "8 GB", 8, SizeUnit.GB),
            MemorySize(0L, "16 GB", 16, SizeUnit.GB),
            MemorySize(0L, "32 GB", 32, SizeUnit.GB),
            MemorySize(0L, "64 GB", 64, SizeUnit.GB),
            MemorySize(0L, "128 GB", 128, SizeUnit.GB),
            MemorySize(0L, "256 GB", 256, SizeUnit.GB)
        )
        memorySizeRepo.saveAll(defaults)
    }

    fun insertDefaultMemoryTypes() {
        if (memoryTypeRepo.count() > 0) return

        val defaults = listOf(
            MemoryType(null, "DDR3", mutableListOf("Legacy", "Up to 2400 MHz", "1.5V")),
            MemoryType(null, "DDR4", mutableListOf("Common", "Up to 5000+ MHz", "1.2V", "288-pin")),
            MemoryType(null, "DDR5", mutableListOf("Latest", "Up to 8000+ MHz", "1.1V", "288-pin", "On-die ECC")),
            MemoryType(null, "DDR4 ECC", mutableListOf("Server", "Error Correction", "Reliability")),
            MemoryType(null, "DDR5 ECC", mutableListOf("Server", "Error Correction", "Latest Generation")),
            MemoryType(null, "SO-DIMM DDR4", mutableListOf("Laptop", "Small Form Factor", "260-pin")),
            MemoryType(null, "SO-DIMM DDR5", mutableListOf("Laptop", "Small Form Factor", "262-pin"))
        )
        memoryTypeRepo.saveAll(defaults)
    }

    fun insertAllDefaults() {
        insertDefaultMotherboardChipsets()
        insertDefaultComputerTypes()
        insertDefaultCpuFrequencies()
        insertDefaultCpuGenerations()
        insertDefaultHardDriveSizes()
        insertDefaultHardDriveTypes()
        insertDefaultMemoryFrequencies()
        insertDefaultMemorySizes()
        insertDefaultMemoryTypes()
    }
}

@Configuration
class ComputerDataDefaultsConfig {

    @Bean
    fun initializeComputerDataDefaults(initializer: ComputerDataDefaultsInitializer): CommandLineRunner {
        return CommandLineRunner {
            initializer.insertAllDefaults()
        }
    }
}