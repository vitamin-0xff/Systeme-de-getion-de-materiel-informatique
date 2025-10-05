package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CpuService(
    private val repo: CpuRepository,
    private val marques: MarqueRepository
) {
    @Transactional
    fun create(req: CpuRequest): CpuResponse {
        val marque = req.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        return repo.save(req.toEntity(marque)).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<CpuResponse> = repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID): CpuResponse = repo.findById(id).orElseThrow { RuntimeException("Cpu not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: CpuUpdate): CpuResponse {
        val entity = repo.findById(id).orElseThrow { RuntimeException("Cpu not found: $id") }
        val marque = u.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        entity.applyUpdate(u, marque)
        return repo.save(entity).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("Cpu not found: $id")
        repo.deleteById(id)
    }
}