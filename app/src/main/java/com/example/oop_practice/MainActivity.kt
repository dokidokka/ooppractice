package com.example.oop_practice

import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.oop_practice.source.vehicles.ElectricScooter
import com.example.oop_practice.source.vehicles.Vehicle
import com.example.oop_practice.source.vehicles.Car
import com.example.oop_practice.source.vehicles.Serviceable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this).apply {
            setPadding(48, 48, 48, 48)
            textSize = 14f
            setTextIsSelectable(true)
            typeface = android.graphics.Typeface.MONOSPACE
        }

        val scrollView = ScrollView(this).apply { addView(textView) }

        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        setContentView(scrollView)
        textView.text = buildOutput()
    }

    private fun buildOutput(): String {
        val out = StringBuilder()
        val myVehicles: List<Vehicle> = listOf(
            Car("Toyota", "Yaris", 2020, 1000),
            Car("Toyota", "Yaris", 2021),
            Car("Tesla", "Model X"),
            ElectricScooter("Yandex", "Naprokat", 2022),
            ElectricScooter("Yandex", "222", 2021, 5)
        )

        for (str in myVehicles) {
            out.appendLine(str.toString())
            out.appendLine(str.hashCode())
            out.appendLine("Двигаемся: ${str.move()}")
            out.appendLine("Тип топлива: ${str.fuelType()}")

            if (str is Serviceable) {
                out.appendLine("Нужен сервис: ${str.isServiceNeeded()}")
                out.appendLine(str.service(out))
            }
            out.appendLine()
        }

        val myCar = Car("Nissan", "Leaf", 2015, 1000)
        val yourCar = Car("Nissan", "Leaf", 2015, 5000)

        out.appendLine("myCar = yourCar: ${myCar == yourCar}")

        return out.toString()
    }
}