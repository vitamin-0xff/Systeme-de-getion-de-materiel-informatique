package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.memory

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/memories")
class MemoryController(private val service: MemoryService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: MemoryRequest): MemoryResponse =
        service.create(request)

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable): Page<MemoryResponse> =
        service.list(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): MemoryResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: MemoryUpdate): MemoryResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
