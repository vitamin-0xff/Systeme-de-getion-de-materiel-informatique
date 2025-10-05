package com.hardware.managmentsystem.hardwaremanagementsystem.provider

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/providers")
class ProviderController(private val service: ProviderService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: ProviderRequest): ProviderResponse =
        service.create(request)

    @GetMapping
    fun list(
        @RequestParam(required = false) q: String?,
        @PageableDefault(size = 20) pageable: Pageable
    ): Page<ProviderResponse> =
        service.list(q, pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): ProviderResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: ProviderUpdate): ProviderResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
