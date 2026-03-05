package com.hardware.managmentsystem.hardwaremanagementsystem.provider

import com.hardware.managmentsystem.hardwaremanagementsystem.services.storage_service.StorageService
import com.hardware.managmentsystem.hardwaremanagementsystem.utils.base64ToBytes
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ProviderService(
    private val repo: ProviderRepository,
    @Qualifier("minio-service")
    private val storageService: StorageService,
) {

    @Transactional
    fun create(req: ProviderRequest): ProviderResponse  {
        val base64Image = req.imageUrl?.split(",")?.getOrNull(1)
        base64Image?.let {
            val byteArray = base64ToBytes(base64Image)
            val uuid = UUID.randomUUID()
            storageService.upload(byteArray, "$uuid.jpg")
            req.imageUrl = "$uuid.jpg"
        }
        return repo.save(req.toEntity()).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(q: String?, pageable: Pageable): Page<ProviderResponse> =
        (if (q.isNullOrBlank()) repo.findAll(pageable) else repo.findByNameContainingIgnoreCase(q, pageable))
            .map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID): ProviderResponse =
        repo.findById(id).orElseThrow { RuntimeException("Provider not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: ProviderUpdate): ProviderResponse =
        repo.findById(id).orElseThrow { RuntimeException("Provider not found: $id") }
            .apply { applyUpdate(u) }
            .let { repo.save(it).toResponse() }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Provider not found: $id")
        repo.deleteById(id)
    }
}
