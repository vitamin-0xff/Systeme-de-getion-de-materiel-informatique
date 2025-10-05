
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu

import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import java.util.UUID

data class CpuRequest(
    val name: String,
    val frequency: Float,
    val freqUnit: FreqUnit = FreqUnit.GHz,
    val generation: String,
    val cacheSize: String,
    val numberCores: Int,
    val socket: String? = null,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class CpuUpdate(
    val name: String? = null,
    val frequency: Float? = null,
    val freqUnit: FreqUnit? = null,
    val generation: String? = null,
    val cacheSize: String? = null,
    val numberCores: Int? = null,
    val socket: String? = null,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class CpuResponse(
    val id: UUID,
    val name: String,
    val frequency: Float,
    val freqUnit: FreqUnit,
    val generation: String,
    val cacheSize: String,
    val numberCores: Int,
    val socket: String?,
    val marqueId: UUID?,
    val imageUrl: String?
)

fun CpuRequest.toEntity(marque: MarqueEntity?) = CpuEntity(
    name = name,
    frequency = frequency,
    freqUnit = freqUnit,
    generation = generation,
    cacheSize = cacheSize,
    numberCores = numberCores,
    socket = socket,
    marque = marque,
    imageUrl = imageUrl
)

fun CpuEntity.applyUpdate(u: CpuUpdate, marque: MarqueEntity?) {
    u.name?.let { name = it }
    u.frequency?.let { frequency = it }
    u.freqUnit?.let { freqUnit = it }
    u.generation?.let { generation = it }
    u.cacheSize?.let { cacheSize = it }
    u.numberCores?.let { numberCores = it }
    if (u.socket != null) socket = u.socket
    if (u.imageUrl != null) imageUrl = u.imageUrl
    if (u.marqueId == null) this.marque = null
    else marque?.let { this.marque = it }
}

fun CpuEntity.toResponse() = CpuResponse(
    id = id!!,
    name = name,
    frequency = frequency,
    freqUnit = freqUnit,
    generation = generation,
    cacheSize = cacheSize,
    numberCores = numberCores,
    socket = socket,
    marqueId = marque?.id,
    imageUrl = imageUrl
)
