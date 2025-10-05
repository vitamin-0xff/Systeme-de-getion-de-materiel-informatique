
package com.hardware.managmentsystem.hardwaremanagementsystem.marque

import com.hardware.managmentsystem.hardwaremanagementsystem._config.MarquesType
import java.util.*

data class MarqueRequest(
    val uuid: UUID? = null,
    val label: String,
    val businessNumber: String? = null,
    val imageUrl: String? = null,
    val types: List<MarquesType>? = null
)

data class MarqueUpdate(
    val label: String? = null,
    val businessNumber: String? = null,
    val imageUrl: String? = null
)

data class MarqueResponse(
    val id: UUID,
    val label: String,
    val businessNumber: String?,
    val imageUrl: String?,
    val marquesTypes: List<MarquesType>? = null
)

fun MarqueRequest.toEntity() = MarqueEntity(label, businessNumber, imageUrl, types?.toMutableList() ?: mutableListOf())

fun MarqueEntity.applyUpdate(u: MarqueUpdate) {
    u.label?.let { label = it }
    if (u.businessNumber != null) businessNumber = u.businessNumber
    if (u.imageUrl != null) imageUrl = u.imageUrl
}

fun MarqueEntity.toResponse() = MarqueResponse(id!!, label, businessNumber, imageUrl, marquesTypes = types)
