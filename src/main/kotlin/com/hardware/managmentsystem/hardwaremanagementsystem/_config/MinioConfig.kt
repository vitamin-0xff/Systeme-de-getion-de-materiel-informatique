package com.hardware.managmentsystem.hardwaremanagementsystem._config

import io.minio.MinioClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MinioConfig(
    @Value("\${minio.config.host}") private val url: String,
    @Value("\${minio.config.username}") private val accessKey: String,
    @Value("\${minio.config.secret}") private val secretKey: String
) {

    @Bean
    fun minioClient(): MinioClient =
        MinioClient.builder()
            .endpoint(url)
            .credentials(accessKey, secretKey)
            .build()
}