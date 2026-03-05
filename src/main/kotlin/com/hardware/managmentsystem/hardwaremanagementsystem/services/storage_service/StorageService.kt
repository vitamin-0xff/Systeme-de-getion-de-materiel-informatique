package com.hardware.managmentsystem.hardwaremanagementsystem.services.storage_service

interface StorageService {
    /**
     * @param file the file to upload
     * @param endpoint the endpoint to upload the file
     * @return the end of the uploaded file
     */
    fun upload(file: ByteArray, endpoint: String): String

    /**
     * @param endpoint the endpoint to delete the file
     * @return true if the file was deleted, false otherwise
     */
    fun delete(endpoint: String): Boolean

    /**
     * @param endpoint the endpoint to check if the file exists
     * @return true if the file exists, false otherwise
     */
    fun exists(endpoint: String): Boolean
}