package com.hardware.managmentsystem.hardwaremanagementsystem.services.storage_service

import io.minio.BucketExistsArgs
import io.minio.MinioClient
import io.minio.PutObjectArgs
import io.minio.RemoveObjectArgs
import io.minio.errors.MinioException
import io.minio.errors.ServerException
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Qualifier("minio-service")
@Service
class MinioStorageService(
    val minioClient: MinioClient,
    @Value("\${mini.config.bucket}")
    val bucketName: String
): StorageService {

    override fun upload(file: ByteArray, endpoint: String): String {
        try {
            val putResponse = minioClient.putObject(
                PutObjectArgs.builder()
                    .bucket(bucketName)
                    .`object`(endpoint)
                    .stream(file.inputStream(), -1, 10 * 1024 * 1024)
                    .contentType("image/jpeg")
                    .build()
            )
            return putResponse.`object`()
        }catch (e: MinioException) {
            throw RuntimeException(e.message ?: "MINIO: Unexpected error")
        }catch (e: ServerException) {
            throw RuntimeException(e.message ?: "MINIO: Unexpected error")
        }

    }

    override fun delete(endpoint: String): Boolean {
        try {
            minioClient.removeObject(
                RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .`object`(endpoint)
                    .build()
            )
        }catch (e: MinioException) {
            throw RuntimeException(e.message ?: "MINIO: Unexpected error")
        }catch (e: ServerException) {
            throw RuntimeException(e.message ?: "MINIO: Unexpected error")
        }


        return true
    }

    override fun exists(endpoint: String): Boolean {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())
    }
}