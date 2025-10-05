
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.memory_frequency_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit

data class MemoryFrequencyRequest(
    val label: String,
    val frequency: Float,
    val freqUnit: FreqUnit = FreqUnit.GHz
)

data class MemoryFrequencyUpdate(
    val label: String? = null,
    val frequency: Float? = null,
    val freqUnit: FreqUnit? = null
)

data class MemoryFrequencyResponse(
    val id: Long,
    val label: String,
    val frequency: Float,
    val freqUnit: FreqUnit
)

fun MemoryFrequencyRequest.toEntity() = MemoryFrequency(
    id = null,
    label = label,
    frequency = frequency,
    freqUnit = freqUnit
)

fun MemoryFrequency.applyUpdate(u: MemoryFrequencyUpdate) {
    u.label?.let { label = it }
    u.frequency?.let { frequency = it }
    u.freqUnit?.let { freqUnit = it }
}

fun MemoryFrequency.toResponse() = MemoryFrequencyResponse(
    id = id!!,
    label = label,
    frequency = frequency,
    freqUnit = freqUnit
)
