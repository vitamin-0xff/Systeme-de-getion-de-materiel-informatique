package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.hard_drive_type_datasource

data class HardDriveTypeRequest(
    val label: String,
    val features: MutableList<String> = mutableListOf()
)

data class HardDriveTypeUpdate(
    val label: String? = null,
    val features: MutableList<String>? = null
)

data class HardDriveTypeResponse(
    val id: Long,
    val label: String,
    val features: MutableList<String>
)

fun HardDriveTypeRequest.toEntity() = HardDriveType(
    id = 0L,
    label = label,
    features = features
)

fun HardDriveType.applyUpdate(u: HardDriveTypeUpdate) {
    u.label?.let { label = it }
    u.features?.let { features.clear(); features.addAll(it) }
}

fun HardDriveType.toResponse() = HardDriveTypeResponse(
    id = id!!,
    label = label,
    features = features
)
