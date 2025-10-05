package com.hardware.managmentsystem.hardwaremanagementsystem.hardware

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import com.hardware.managmentsystem.hardwaremanagementsystem._config.HardwareStatus
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/hardware")
class HardwareController(private val service: HardwareService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: HardwareRequest): HardwareResponse =
        service.create(request)

    @GetMapping
    fun list(
        @RequestParam(required = false) status: HardwareStatus?,
        @PageableDefault(size = 20) pageable: Pageable
    ): Page<HardwareResponse> =
        service.list(status, pageable)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): HardwareResponse =
        service.get(id)

    @GetMapping("/serial/{serialNumber}")
    fun getBySerial(@PathVariable serialNumber: String): HardwareResponse =
        service.bySerial(serialNumber)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody update: HardwareUpdate): HardwareResponse =
        service.update(id, update)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) =
        service.delete(id)
}
