package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.computer_motherboard_chipset_datasource

data class MotherboardChipsetRequest(
    val label: String,
    val features: MutableList<String> = mutableListOf()
)

data class MotherboardChipsetUpdate(
    val label: String? = null,
    val features: MutableList<String>? = null
)

data class MotherboardChipsetResponse(
    val id: Long,
    val label: String,
    val features: MutableList<String>
)

fun MotherboardChipsetRequest.toEntity() = MotherboardChipset(
    id = 0L,
    label = label,
    features = features
)

fun MotherboardChipset.applyUpdate(u: MotherboardChipsetUpdate) {
    u.label?.let { label = it }
    u.features?.let { features = it }
}

fun MotherboardChipset.toResponse() = MotherboardChipsetResponse(
    id = id!!,
    label = label,
    features = features
)
