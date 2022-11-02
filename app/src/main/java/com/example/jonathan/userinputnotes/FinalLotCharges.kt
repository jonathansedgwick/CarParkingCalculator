package com.example.jonathan.userinputnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class FinalLotCharges : AppCompatActivity() {

    lateinit var resultText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_lot_charges)

        resultText = findViewById(R.id.resultOutput2)
        val hours = intent.getIntExtra("EXTRA_HOURS", 0)
        val lotChoice = intent.getStringExtra("EXTRA_LOTCHOICE")
        val totalCharges = intent.getStringExtra("EXTRA_CHARGES")

        var finalCharges = "Cost for parking in $lotChoice for $hours hours is $totalCharges"
        resultText.text = finalCharges
    }
}