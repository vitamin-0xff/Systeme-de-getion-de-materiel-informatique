package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class HardDriveService(
    private val repo: HardDriveRepository,
    private val marques: MarqueRepository
) {
    @Transactional
    fun create(req: HardDriveRequest): HardDriveResponse {
        val marque = req.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        return repo.save(req.toEntity(marque)).toResponse()
    }

    @Transactional(readOnly = true)
    fun list(pageable: Pageable): Page<HardDriveResponse> = repo.findAll(pageable).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun get(id: UUID): HardDriveResponse = repo.findById(id).orElseThrow { RuntimeException("HardDrive not found: $id") }.toResponse()

    @Transactional
    fun update(id: UUID, u: HardDriveUpdate): HardDriveResponse {
        val entity = repo.findById(id).orElseThrow { RuntimeException("HardDrive not found: $id") }
        val marque = u.marqueId?.let { marques.findById(it).orElseThrow { RuntimeException("Marque not found: $it") } }
        entity.applyUpdate(u, marque)
        return repo.save(entity).toResponse()
    }

    @Transactional
    fun delete(id: UUID) {
        if (!repo.existsById(id)) throw RuntimeException("HardDrive not found: $id")
        repo.deleteById(id)
    }
}
