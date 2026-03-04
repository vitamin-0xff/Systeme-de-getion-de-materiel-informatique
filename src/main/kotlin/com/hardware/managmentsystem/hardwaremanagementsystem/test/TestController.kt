package com.hardware.managmentsystem.hardwaremanagementsystem.test

import com.hardware.managmentsystem.hardwaremanagementsystem._config.ApiError
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("test")
class TestController {

    @GetMapping("/success")
    fun success(): Map<String, String> {
        return mapOf(
            "Message" to "Success"
        )
    }

    @GetMapping("/error")
    fun error() {
        throw ApiError.NotFound("Not Found Error")
    }
}