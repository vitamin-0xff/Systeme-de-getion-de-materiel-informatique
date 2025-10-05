package com.hardware.managmentsystem.hardwaremanagementsystem.provider

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ProviderService(private val repo: ProviderRepository) {

    @Transactional
    fun create(req: ProviderRequest): ProviderResponse =
        repo.save(req.toEntity()).toResponse()

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
