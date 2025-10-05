package com.hardware.managmentsystem.hardwaremanagementsystem.computer.computer_components.hard_drive

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/hard-drives")
class HardDriveController(private val service: HardDriveService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: HardDriveRequest): HardDriveResponse =
        service.create(request)

    @GetMapping
    fun list(@PageableDefault(size = 20) pageable: Pageable): Page<HardDriveResponse> =
        service.list(pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): HardDriveResponse =
        service.get(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: HardDriveUpdate): HardDriveResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
