package com.hardware.managmentsystem.hardwaremanagementsystem.computer.relationships

import com.hardware.managmentsystem.hardwaremanagementsystem.computer.ComputerEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu.CpuEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive.HardDriveEntity
import com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory.MemoryEntity
import com.hardware.managmentsystem.hardwaremanagementsystem._config.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "computer_cpus")
class ComputerCpu(
    @ManyToOne(fetch = FetchType.LAZY) val computer: ComputerEntity,
    @ManyToOne(fetch = FetchType.LAZY) val cpu: CpuEntity
) : BaseEntity()

@Entity
@Table(name = "computer_memories")
class ComputerMemory(
    @ManyToOne(fetch = FetchType.LAZY) val computer: ComputerEntity,
    @ManyToOne(fetch = FetchType.LAZY) val memory: MemoryEntity
) : BaseEntity()

@Entity
@Table(name = "computer_drives")
class ComputerDrive(
    @ManyToOne(fetch = FetchType.LAZY) val computer: ComputerEntity,
    @ManyToOne(fetch = FetchType.LAZY) val drive: HardDriveEntity
) : BaseEntity()