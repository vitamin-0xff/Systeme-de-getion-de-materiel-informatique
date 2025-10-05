package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComputerTypeRepository: JpaRepository<ComputerType, Long>