package com.hardware.managmentsystem.hardwaremanagementsystem._config

import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

@RestControllerAdvice
class APIGlobalAdvice : ResponseBodyAdvice<Any> {
    override fun supports(
        returnType: MethodParameter,
        converterType: Class<out HttpMessageConverter<*>?>
    ): Boolean {
        return true
    }

    override fun beforeBodyWrite(
        body: Any?,
        returnType: MethodParameter,
        selectedContentType: MediaType,
        selectedConverterType: Class<out HttpMessageConverter<*>?>,
        request: ServerHttpRequest,
        response: ServerHttpResponse
    ): Any? {
        val excludedPaths = listOf(
            "swagger-ui",
            "api-docs",
        )
        if(
            excludedPaths.any { request.uri.path.contains(it) }
            ||
            !selectedContentType.includes(MediaType.APPLICATION_JSON)
            ) {
            return body
        }
        if(body is ApiResponse<*>) {
            return  body
        }
        return ApiResponse.success(data = body, statusCode = (response as ServletServerHttpResponse).servletResponse.status, path = request.uri.path)
    }

    @ExceptionHandler(ApiError::class)
    fun handleApiError(error: ApiError)
            : ApiResponse<Nothing> {
        return error.toError(path = "")
    }

}