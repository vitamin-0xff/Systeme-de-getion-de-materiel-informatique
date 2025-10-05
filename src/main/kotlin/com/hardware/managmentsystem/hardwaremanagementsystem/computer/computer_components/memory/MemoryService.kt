
package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class MemoryService(
    private val repo: MemoryRepository,
    private val marques: MarqueRepository
) {
    @Transactional
    fun create(req: MemoryRequest): MemoryResponse {
        val marque = req.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        return repo.save(req.toEntity(marque)).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<MemoryResponse> = repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID): MemoryResponse = repo.findById(id).orElseThrow { RuntimeException("Memory not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: MemoryUpdate): MemoryResponse {
        val entity = repo.findById(id).orElseThrow { RuntimeException("Memory not found: $id") }
        val marque = u.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        entity.applyUpdate(u, marque)
        return repo.save(entity).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Memory not found: $id")
        repo.deleteById(id)
    }
}
