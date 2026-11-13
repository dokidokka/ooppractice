package com.example.oop_practice.source.vehicles

interface Serviceable {
    fun service(out: StringBuilder)
    fun isServiceNeeded(): Boolean
}