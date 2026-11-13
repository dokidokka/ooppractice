package com.example.oop_practice.source.vehicles

import java.time.Year

class ElectricScooter(
    brand: String,
    model: String,
    year: Int,
    private var batteryLevel: Int = 100
) : Vehicle(brand, model, year), Serviceable {

    constructor(brand: String, model: String) : this(brand, model, Year.now().value)

    override fun move(): String = "Самокат движется по тротуару"
    override fun fuelType(): String = "Электричество"
    override fun service(out: StringBuilder) {
        out.appendLine("Проверяем батарею...")
        out.appendLine("Уровень заряда: $batteryLevel")
    }
    override fun isServiceNeeded(): Boolean = batteryLevel < 10

}