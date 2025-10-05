package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.screen

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRepository
import com.hardware.managmentsystem.hardwaremanagementsystem.provider.ProviderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ScreenService(
    private val repo: ScreenRepository,
    private val marques: MarqueRepository,
    private val providers: ProviderRepository
) {
    @Transactional
    fun create(req: ScreenRequest): ScreenResponse {
        val marque = marques.findById(req.marqueId).orElseThrow { RuntimeException("Marque not found: ${req.marqueId}") }
        val provider = req.providerId?.let { providers.findById(it).orElseThrow { RuntimeException("Provider not found: $it") } }
        return repo.save(req.toEntity(marque, provider)).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<ScreenResponse> = repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID) = repo.findById(id).orElseThrow { RuntimeException("Screen not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: ScreenUpdate): ScreenResponse {
        val entity = repo.findById(id).orElseThrow { RuntimeException("Screen not found: $id") }
        val marque = u.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        val provider = u.providerId?.let { providers.findById(it).orElseThrow { RuntimeException("Provider not found: $it") } }
        entity.applyUpdate(u, marque, provider)
        return repo.save(entity).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Screen not found: $id")
        repo.deleteById(id)
    }
}
