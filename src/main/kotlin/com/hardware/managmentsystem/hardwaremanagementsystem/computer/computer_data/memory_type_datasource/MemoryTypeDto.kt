package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_type_datasource

data class MemoryTypeRequest(
    val label: String,
    val features: MutableList<String> = mutableListOf()
)

data class MemoryTypeUpdate(
    val label: String? = null,
    val features: MutableList<String>? = null
)

data class MemoryTypeResponse(
    val id: Long,
    val label: String,
    val features: MutableList<String>
)

fun MemoryTypeRequest.toEntity() = MemoryType(
    id = 0L,
    label = label,
    features = features
)

fun MemoryType.applyUpdate(u: MemoryTypeUpdate) {
    u.label?.let { label = it }
    u.features?.let { features.clear(); features.addAll(it) }
}

fun MemoryType.toResponse() = MemoryTypeResponse(
    id = id!!,
    label = label,
    features = features
)
