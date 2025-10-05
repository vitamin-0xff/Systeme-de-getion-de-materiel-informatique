
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_type_datasource

data class ComputerTypeRequest(
    val label: String,
    val features: MutableList<String> = mutableListOf()
)

data class ComputerTypeUpdate(
    val label: String? = null,
    val features: MutableList<String>? = null
)

data class ComputerTypeResponse(
    val id: Long,
    val label: String,
    val features: MutableList<String>
)

fun ComputerTypeRequest.toEntity() = ComputerType(
    id = null,
    label = label,
    features = features
)

fun ComputerType.applyUpdate(u: ComputerTypeUpdate) {
    u.label?.let { label = it }
    u.features?.let { features.clear(); features.addAll(it) }
}

fun ComputerType.toResponse() = ComputerTypeResponse(
    id = id!!,
    label = label,
    features = features
)
