package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_size_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit

data class HardDriveSizeRequest(
    val label: String,
    val size: Long,
    val sizeUnit: SizeUnit = SizeUnit.GB
)

data class HardDriveSizeUpdate(
    val label: String? = null,
    val size: Long? = null,
    val sizeUnit: SizeUnit? = null
)

data class HardDriveSizeResponse(
    val id: Long,
    val label: String,
    val size: Long,
    val sizeUnit: SizeUnit
)

fun HardDriveSizeRequest.toEntity() = HardDriveSize(
    id = 0L,
    label = label,
    size = size,
    sizeUnit = sizeUnit
)

fun HardDriveSize.applyUpdate(u: HardDriveSizeUpdate) {
    u.label?.let { label = it }
    u.size?.let { size = it }
    u.sizeUnit?.let { sizeUnit = it }
}

fun HardDriveSize.toResponse() = HardDriveSizeResponse(
    id = id!!,
    label = label,
    size = size,
    sizeUnit = sizeUnit
)
