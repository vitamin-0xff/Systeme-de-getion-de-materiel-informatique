package com.hardware.managmentsystem.hardwaremanagementsystem._config

sealed class ApiError(
    override val message: String,
    open val status: Int,
    open val errorList: List<String> = emptyList()
): RuntimeException(message) {
    /* =========================
       400 — Client Errors
       ========================= */

    data class BadRequest(
        override val message: String = "Bad request"
    ) : ApiError(message, 400)

    data class ValidationError(
        val errors: Map<String, String?>,
        override val message: String = "Validation failed"
    ) : ApiError(message, 400)

    data class Unauthorized(
        override val message: String = "Unauthorized"
    ) : ApiError(message, 401)

    data class Forbidden(
        override val message: String = "Forbidden"
    ) : ApiError(message, 403)

    data class NotFound(
        override val message: String = "Resource not found"
    ) : ApiError(message, 404)

    data class MethodNotAllowed(
        override val message: String = "Method not allowed"
    ) : ApiError(message, 405)

    data class Conflict(
        override val message: String = "Resource conflict"
    ) : ApiError(message, 409)

    data class UnsupportedMediaType(
        override val message: String = "Unsupported media type"
    ) : ApiError(message, 415)

    data class TooManyRequests(
        override val message: String = "Too many requests"
    ) : ApiError(message, 429)

    /* =========================
       500 — Server Errors
       ========================= */

    data class InternalServerError(
        override val message: String = "Internal server error"
    ) : ApiError(message, 500)

    data class NotImplemented(
        override val message: String = "Not implemented"
    ) : ApiError(message, 501)

    data class ServiceUnavailable(
        override val message: String = "Service unavailable"
    ) : ApiError(message, 503)

    data class GatewayTimeout(
        override val message: String = "Gateway timeout"
    ) : ApiError(message, 504)

    fun toError(path: String): ApiResponse<Nothing> {
            return ApiResponse.error(
                path = path,
                statusCode = status,
                message = message,
                errorList = errorList
            )
    }
}