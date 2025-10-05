package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_size_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit

data class MemorySizeRequest(
    val label: String,
    val size: Long,
    val sizeUnit: SizeUnit = SizeUnit.GB
)

data class MemorySizeUpdate(
    val label: String? = null,
    val size: Long? = null,
    val sizeUnit: SizeUnit? = null
)

data class MemorySizeResponse(
    val id: Long,
    val label: String,
    val size: Long,
    val sizeUnit: SizeUnit
)

fun MemorySizeRequest.toEntity() = MemorySize(
    id = 0L,
    label = label,
    size = size,
    sizeUnit = sizeUnit
)

fun MemorySize.applyUpdate(u: MemorySizeUpdate) {
    u.label?.let { label = it }
    u.size?.let { size = it }
    u.sizeUnit?.let { sizeUnit = it }
}

fun MemorySize.toResponse() = MemorySizeResponse(
    id = id,
    label = label,
    size = size,
    sizeUnit = sizeUnit
)
