package com.example.jonathan.userinputnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
import java.text.DecimalFormat

lateinit var titleText: TextView
lateinit var hoursInput: EditText
lateinit var resultText: TextView
lateinit var parkingImage: ImageView
lateinit var lotDropdown: Spinner
lateinit var calculateButton: Button

const val costPerHour = 1.50
var numHours: Int = 0
var totalCharges: Double = 0.0
var lotChoice = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.titleText)
        hoursInput = findViewById(R.id.hoursInput)
        resultText = findViewById(R.id.resultText)
        parkingImage = findViewById(R.id.parkingImage)
        lotDropdown = findViewById(R.id.lotDropdown)
        calculateButton = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener{
            if(checkData()) {
                numHours = hoursInput.text.toString().toInt()
                lotChoice = lotDropdown.selectedItem.toString()
                totalCharges = costPerHour * numHours

                val currency = DecimalFormat("$##,###.00")
                val totalFormatted = currency.format(totalCharges)
                resultText.text =
                    "Cost for parking in $lotChoice for $numHours hours is $totalFormatted"

                Intent(this@MainActivity, FinalLotCharges::class.java).also {

                    it.putExtra("EXTRA_HOURS", numHours)
                    it.putExtra("EXTRA_LOTCHOICE", lotChoice)
                    it.putExtra("EXTRA_CHARGES", totalFormatted)
                    startActivity(it)
                }
            }
        }

    }

    private fun checkData(): Boolean {

        if (hoursInput.text.toString().isEmpty()) {
            hoursInput.error = "Invalid Hour Input"
            hoursInput.requestFocus()
            return false
        }
        else
            return true


    }
}