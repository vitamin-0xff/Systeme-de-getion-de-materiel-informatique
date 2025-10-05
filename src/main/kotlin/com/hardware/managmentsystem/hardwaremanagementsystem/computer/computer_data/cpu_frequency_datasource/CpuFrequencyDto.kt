
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_data.cpu_frequency_datasource

import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit

data class CpuFrequencyRequest(
    val label: String,
    val frequency: Float,
    val freqUnit: FreqUnit = FreqUnit.GHz
)

data class CpuFrequencyUpdate(
    val label: String? = null,
    val frequency: Float? = null,
    val freqUnit: FreqUnit? = null
)

data class CpuFrequencyResponse(
    val id: Long,
    val label: String,
    val frequency: Float,
    val freqUnit: FreqUnit
)

fun CpuFrequencyRequest.toEntity() = CpuFrequency(
    id = null,
    label = label,
    frequency = frequency,
    freqUnit = freqUnit
)

fun CpuFrequency.applyUpdate(u: CpuFrequencyUpdate) {
    u.label?.let { label = it }
    u.frequency?.let { frequency = it }
    u.freqUnit?.let { freqUnit = it }
}

fun CpuFrequency.toResponse() = CpuFrequencyResponse(
    id = id!!,
    label = label,
    frequency = frequency,
    freqUnit = freqUnit
)
