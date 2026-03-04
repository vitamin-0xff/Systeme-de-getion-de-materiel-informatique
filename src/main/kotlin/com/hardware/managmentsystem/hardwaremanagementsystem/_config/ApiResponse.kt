package com.hardware.managmentsystem.hardwaremanagementsystem._config

import java.time.LocalDateTime
import java.time.ZoneOffset

data class ApiResponse<T>(
    val path: String,
    val statusCode: Int,
    val data: T?,
    val error: List<String> = emptyList(),
    val message: String = "",
    val timestamp: Long = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC),
    val success: Boolean
) {
    companion object {
        fun <T> success(data: T, path: String, statusCode: Int = 200, message: String? = null): ApiResponse<T> {
            return ApiResponse(
                path = path,
                data = data,
                statusCode = statusCode,
                message = message ?: "Request Successfully Processed",
                success = true
            )
        }
        fun error(path: String, statusCode: Int, message: String, errorList: List<String> = emptyList()): ApiResponse<Nothing> {
            return ApiResponse (
                path= path,
                statusCode= statusCode,
                message = message,
                error =  errorList,
                data = null,
                success = false
            )
        }
    }
}