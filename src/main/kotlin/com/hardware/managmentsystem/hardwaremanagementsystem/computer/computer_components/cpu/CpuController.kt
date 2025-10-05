package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.cpu

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/cpus")
class CpuController(private val service: CpuService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CpuRequest): CpuResponse =
        service.create(request)

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable): Page<CpuResponse> =
        service.list(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): CpuResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: CpuUpdate): CpuResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
