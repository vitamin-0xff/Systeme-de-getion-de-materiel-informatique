package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral.components.screen

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/screens")
class ScreenController(private val service: ScreenService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ScreenRequest): ScreenResponse =
        service.create(request)

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable): Page<ScreenResponse> =
        service.list(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): ScreenResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: ScreenUpdate): ScreenResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
