package com.hardware.managmentsystem.hardwaremanagementsystem.utils

import kotlin.io.encoding.Base64

fun base64ToBytes(base64Image: String): ByteArray {
    return java.util.Base64.getDecoder().decode(base64Image)
}