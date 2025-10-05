
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory

import com.hardware.managmentsystem.hardwaremanagementsystem._config.FreqUnit
import com.hardware.managmentsystem.hardwaremanagementsystem._config.SizeUnit
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueEntity
import java.util.UUID

data class MemoryRequest(
    val name: String,
    val frequency: Float,
    val sizeUnit: SizeUnit = SizeUnit.GB,
    val freqUnit: FreqUnit = FreqUnit.GHz,
    val size: Float,
    val type: String,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class MemoryUpdate(
    val name: String? = null,
    val frequency: Float? = null,
    val sizeUnit: SizeUnit? = null,
    val freqUnit: FreqUnit? = null,
    val size: Float? = null,
    val type: String? = null,
    val marqueId: UUID? = null,
    val imageUrl: String? = null
)

data class MemoryResponse(
    val id: UUID,
    val name: String,
    val frequency: Float,
    val sizeUnit: SizeUnit,
    val freqUnit: FreqUnit,
    val size: Float,
    val type: String,
    val marqueId: UUID?,
    val imageUrl: String?
)

fun MemoryRequest.toEntity(marque: MarqueEntity?) = MemoryEntity(
    name = name,
    frequency = frequency,
    sizeUnit = sizeUnit,
    freqUnit = freqUnit,
    size = size,
    type = type,
    marque = marque,
    imageUrl = imageUrl
)

fun MemoryEntity.applyUpdate(u: MemoryUpdate, marque: MarqueEntity?) {
    u.name?.let { name = it }
    u.frequency?.let { frequency = it }
    u.sizeUnit?.let { sizeUnit = it }
    u.freqUnit?.let { freqUnit = it }
    u.size?.let { size = it }
    u.type?.let { type = it }
    if (u.imageUrl != null) imageUrl = u.imageUrl
    if (u.marqueId == null) this.marque = null
    else marque?.let { this.marque = it }
}

fun MemoryEntity.toResponse() = MemoryResponse(
    id = id!!,
    name = name,
    frequency = frequency,
    sizeUnit = sizeUnit,
    freqUnit = freqUnit,
    size = size,
    type = type,
    marqueId = marque?.id,
    imageUrl = imageUrl
)
