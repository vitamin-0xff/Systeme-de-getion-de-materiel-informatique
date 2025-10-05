package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HardDriveTypeRepository: JpaRepository<HardDriveType, Long>