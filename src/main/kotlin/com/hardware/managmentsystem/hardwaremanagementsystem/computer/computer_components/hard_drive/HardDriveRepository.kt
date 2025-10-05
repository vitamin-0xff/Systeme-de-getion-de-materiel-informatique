package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface HardDriveRepository : JpaRepository<HardDriveEntity, UUID>
