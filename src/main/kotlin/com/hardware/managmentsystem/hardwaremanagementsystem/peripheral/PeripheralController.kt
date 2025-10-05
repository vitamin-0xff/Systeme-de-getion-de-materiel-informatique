
package com.hardware.managmentsystem.hardwaremanagementsystem.peripheral

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/peripherals")
class PeripheralController(private val service: PeripheralService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PeripheralRequest): PeripheralResponse =
        service.create(request)

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable): Page<PeripheralResponse> =
        service.list(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): PeripheralResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: PeripheralUpdate): PeripheralResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
