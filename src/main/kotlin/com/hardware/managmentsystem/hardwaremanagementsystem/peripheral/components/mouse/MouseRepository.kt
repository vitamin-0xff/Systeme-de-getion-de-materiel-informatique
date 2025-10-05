package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.mouse

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MouseRepository : JpaRepository<MouseEntity, UUID>
