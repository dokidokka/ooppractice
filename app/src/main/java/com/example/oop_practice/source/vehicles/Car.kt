package com.example.oop_practice.source.vehicles

import java.time.Year

class Car(
    brand: String,
    model: String,
    year: Int,
    private var mileage: Int = 0
) : Vehicle(brand, model, year), Serviceable {

    constructor(brand: String, model: String) : this(brand, model, Year.now().value)

    override fun move(): String = "Машина едет по дороге"
    override fun fuelType(): String = "Бэнзин"
    override fun service(out: StringBuilder) {
        out.appendLine("Никакого ТС")
    }
    override fun isServiceNeeded(): Boolean = mileage > 10000


}