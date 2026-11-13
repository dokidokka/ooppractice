package com.example.oop_practice.source.vehicles

abstract class Vehicle(
    protected val brand: String,
    protected val model: String,
    protected val year: Int
) {

    init {
        require(year > 1885) {
            "Слишком стар"
        }
    }

    abstract fun move(): String
    abstract fun fuelType(): String

    override fun equals(other: Any?): Boolean {
        if (other !is Vehicle) return false
        if (this === other) return true
        return brand == other.brand && model == other.model && year == other.year
    }

    override fun hashCode(): Int {
        val res = brand.hashCode() + model.hashCode() + year

        return res
    }

    override fun toString(): String = "$brand $model $year"

}