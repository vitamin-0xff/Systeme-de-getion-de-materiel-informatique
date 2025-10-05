package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_generation_datasource

data class CpuGenerationRequest(
    val label: String,
    val generation: String,
    val features: MutableList<String> = mutableListOf()
)

data class CpuGenerationUpdate(
    val label: String? = null,
    val generation: String? = null,
    val features: MutableList<String>? = null
)

data class CpuGenerationResponse(
    val id: Long,
    val label: String,
    val generation: String,
    val features: MutableList<String>
)

fun CpuGenerationRequest.toEntity() = CpuGeneration(
    id = null,
    label = label,
    generation = generation,
    features = features
)

fun CpuGeneration.applyUpdate(u: CpuGenerationUpdate) {
    u.label?.let { label = it }
    u.generation?.let { generation = it }
    u.features?.let { features.clear(); features.addAll(it) }
}

fun CpuGeneration.toResponse() = CpuGenerationResponse(
    id = id!!,
    label = label,
    generation = generation,
    features = features
)
