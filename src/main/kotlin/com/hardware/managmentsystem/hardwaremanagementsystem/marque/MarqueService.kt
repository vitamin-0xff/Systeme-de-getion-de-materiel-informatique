package com.hardware.managmentsystem.hardwaremanagementsystem.marque

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class MarqueService(private val repo: MarqueRepository) {

    @Transactional
    fun create(req: MarqueRequest) = repo.save(req.toEntity()).toResponse()

    @Transactional(readOnly = true)
    fun list(q: String?, pageable: Pageable) = (if (q.isNullOrBlank()) repo.findAll(pageable) else repo.findByLabelContainingIgnoreCase(q, pageable))
        .map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID) = repo.findById(id).orElseThrow { RuntimeException("Marque not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: MarqueUpdate) =
        repo.findById(id).orElseThrow { RuntimeException("Marque not found: $id") }
            .apply { applyUpdate(u) }
            .let { repo.save(it).toResponse() }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Marque not found: $id")
        repo.deleteById(id)
    }
}
