package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.screen

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ScreenRepository : JpaRepository<ScreenEntity, UUID>
