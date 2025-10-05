package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.keyboard

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface KeyboardRepository : JpaRepository<KeyboardEntity, UUID>
