
package com.hardware.managmentsystem.hardwaremanagementsystem.provider
import java.util.*

data class ProviderRequest(
    val name: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val businessNumber: String? = null,
    val imageUrl: String? = null,
    val businessName: String? = null,
    val businessId: String? = null
)

data class ProviderUpdate(
    val name: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val businessNumber: String? = null,
    val imageUrl: String? = null,
    val businessName: String? = null,
    val businessId: String? = null
)

data class ProviderResponse(
    val id: UUID,
    val name: String,
    val email: String?,
    val phoneNumber: String?,
    val businessNumber: String?,
    val imageUrl: String?,
    val businessName: String?,
    val businessId: String?
)

// Mappers
fun ProviderRequest.toEntity() = ProviderEntity(
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    businessNumber = businessNumber,
    imageUrl = imageUrl,
    businessName = businessName,
    businessId = businessId
)

fun ProviderEntity.applyUpdate(u: ProviderUpdate) {
    u.name?.let { name = it }
    if (u.email != null) email = u.email
    if (u.phoneNumber != null) phoneNumber = u.phoneNumber
    if (u.businessNumber != null) businessNumber = u.businessNumber
    if (u.imageUrl != null) imageUrl = u.imageUrl
    if (u.businessName != null) businessName = u.businessName
    if (u.businessId != null) businessId = u.businessId
}

fun ProviderEntity.toResponse() = ProviderResponse(
    id = id!!,
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    businessNumber = businessNumber,
    imageUrl = imageUrl,
    businessName = businessName,
    businessId = businessId
)
