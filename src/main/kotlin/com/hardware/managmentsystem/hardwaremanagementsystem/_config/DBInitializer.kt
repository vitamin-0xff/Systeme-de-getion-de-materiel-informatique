package com.hardware.managmentsystem.hardwaremanagementsystem._config

import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueRequest
import com.hardware.managmentsystem.hardwaremanagementsystem.marque.MarqueService
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.awt.print.Pageable
import java.util.UUID

@Configuration
class DBInitializer(
    val marqueService: MarqueService
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val mockMarques = listOf(
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111001"), "Dell", "DELL12345", "https://example.com/images/dell.png", mutableListOf(MarquesType.COMPUTER, MarquesType.SERVER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111002"), "HP", "HP98765", null, mutableListOf(MarquesType.COMPUTER, MarquesType.SERVER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111003"), "Lenovo", "LEN45678", null, mutableListOf(MarquesType.COMPUTER, MarquesType.SERVER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111004"), "Asus", "ASUS11223", null, mutableListOf(MarquesType.COMPUTER, MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111005"), "Acer", "ACER33445", null, mutableListOf(MarquesType.COMPUTER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111006"), "Corsair", "CORSAIR001", null, mutableListOf(MarquesType.KEYBOARD, MarquesType.MEMORY)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111007"), "Logitech", "LOGI002", null, mutableListOf(MarquesType.MOUSE, MarquesType.KEYBOARD)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111008"), "Razer", "RAZER001", null, mutableListOf(MarquesType.KEYBOARD, MarquesType.MOUSE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111009"), "Intel", "INTEL001", null, mutableListOf(MarquesType.CPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111010"), "AMD", "AMD001", null, mutableListOf(MarquesType.CPU, MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111011"), "Nvidia", "NV001", null, mutableListOf(MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111012"), "MSI", "MSI001", null, mutableListOf(MarquesType.MOTHERBOARD, MarquesType.GPU, MarquesType.COMPUTER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111013"), "Samsung", "SAM001", null, mutableListOf(MarquesType.SCREEN, MarquesType.MEMORY, MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111014"), "Kingston", "KING001", null, mutableListOf(MarquesType.MEMORY, MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111015"), "Seagate", "SEAG001", null, mutableListOf(MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111016"), "Western Digital", "WD001", null, mutableListOf(MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111017"), "Gigabyte", "GIGA001", null, mutableListOf(MarquesType.MOTHERBOARD, MarquesType.COMPUTER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111018"), "EVGA", "EVGA001", null, mutableListOf(MarquesType.GPU, MarquesType.COMPUTER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111021"), "AOC", "AOC001", null, mutableListOf(MarquesType.SCREEN)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111022"), "BenQ", "BENQ001", null, mutableListOf(MarquesType.SCREEN)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111023"), "HyperX", "HX001", null, mutableListOf(MarquesType.MEMORY, MarquesType.KEYBOARD)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111024"), "SteelSeries", "SS001", null, mutableListOf(MarquesType.KEYBOARD, MarquesType.MOUSE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111025"), "ASRock", "ASR001", null, mutableListOf(MarquesType.MOTHERBOARD, MarquesType.COMPUTER)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111026"), "Patriot", "PAT001", null, mutableListOf(MarquesType.MEMORY)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111027"), "AMD Radeon", "AMD-R001", null, mutableListOf(MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111028"), "Nvidia GeForce", "NV-G001", null, mutableListOf(MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111029"), "TP-Link", "TPL001", null, mutableListOf(MarquesType.NETWORK)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111030"), "Netgear", "NET001", null, mutableListOf(MarquesType.NETWORK)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111031"), "Logitech G", "LOGI-G001", null, mutableListOf(MarquesType.KEYBOARD, MarquesType.MOUSE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111032"), "Razer BlackWidow", "RAZER-B001", null, mutableListOf(MarquesType.KEYBOARD)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111033"), "Cooler Master Keyboard", "CM-K001", null, mutableListOf(MarquesType.KEYBOARD)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111034"), "Corsair RAM", "COR-R001", null, mutableListOf(MarquesType.MEMORY)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111035"), "Kingston SSD", "KING-SSD001", null, mutableListOf(MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111036"), "Samsung SSD", "SAM-SSD001", null, mutableListOf(MarquesType.HARD_DRIVE)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111037"), "Asus ROG GPU", "ASUS-GPU001", null, mutableListOf(MarquesType.GPU)),
            MarqueRequest(UUID.fromString("11111111-1111-1111-1111-111111111038"), "MSI Motherboard", "MSI-MB001", null, mutableListOf(MarquesType.MOTHERBOARD, MarquesType.COMPUTER)),
        )
        mockMarques.forEach { marqueService.create(it) }
    }
}