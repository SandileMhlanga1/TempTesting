package com.example.mypizza

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.RadioGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val chkOlives = findViewById<CheckBox>(R.id.chkOlives)
        val chkCheese = findViewById<CheckBox>(R.id.chkCheese)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val rbSmall = findViewById<RadioButton>(R.id.rbSmall)
        val rbMedium = findViewById<RadioButton>(R.id.rbMedium)
        val rbLarge = findViewById<RadioButton>(R.id.rbLarge)

        btnCalculate.setOnClickListener{
            var total = 0.0



            if(rbSmall.isChecked)
            {
                total += 55.99// total = total + 55.99
            }
            else if(rbMedium.isChecked)
            {
                total += 89.99
            }
            else if(rbLarge.isChecked)
            {
                total += 119.99
            }


            if (chkCheese.isChecked)
            {
                total += 5.50
            }


            if (chkOlives.isChecked) {
                total += 3.50
            }
            txtResults.text = String.format("Total Amount Due: R%.2f", total)
        }
        btnClear.setOnClickListener{
            txtResults.text = ""
            //radioGroupSize.clearCheck()
            rbSmall.isChecked = false
            rbMedium.isChecked = false
            rbLarge.isChecked = false
            chkCheese.isChecked = false
            chkOlives.isChecked = false



        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}