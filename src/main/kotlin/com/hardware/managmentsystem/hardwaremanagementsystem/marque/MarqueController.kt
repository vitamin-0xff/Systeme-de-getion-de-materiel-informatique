package com.hardware.managmentsystem.hardwaremanagementsystem.marque

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/marques")
class MarqueController(private val service: MarqueService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: MarqueRequest): MarqueResponse =
        service.create(request)

    @PostMapping("all")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAll(@RequestBody request: List<MarqueRequest>): List<MarqueResponse>  {
        val marques = mutableListOf<MarqueResponse>()
        for (marque in request) {
            marques.add(service.create(marque))
        }
        return marques
    }

    @GetMapping
    fun list(
        @RequestParam(required = false) q: String?,
        @PageableDefault(size = 20) pageable: Pageable
    ): Page<MarqueResponse> =
        service.list(q, pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): MarqueResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: MarqueUpdate): MarqueResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
