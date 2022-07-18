package com.example.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Linking UI to Program
        val imageViewBMI:ImageView = findViewById(R.id.imageView_bmi)
        val textViewBMI:TextView = findViewById(R.id.textView_bmi)
        val editTextHeight:EditText = findViewById(R.id.editText_height)
        val editTextWeight:EditText = findViewById(R.id.editText_weight)
        val btnCalculate:Button = findViewById(R.id.button_calculate)
        val btnReset:Button = findViewById(R.id.button_reset)

        btnCalculate.setOnClickListener{
            if (editTextWeight.text.toString().isNotEmpty() || editTextHeight.text.toString().isNotEmpty()){
                val height = editTextHeight.text.toString().toFloat()
                val weight = editTextWeight.text.toString().toFloat()
                val bmi = weight/(height/100).pow(2)

                if(bmi < 18.5){
                    textViewBMI.text = String.format("%s : %s (%.2f)",
                        getString(R.string.bmi),getString(R.string.status1),bmi)
                    imageViewBMI.setImageResource(R.drawable.under)

                }else if(bmi >= 18.5 && bmi < 24.9){
                    textViewBMI.text = String.format("%s : %s (%.2f)",
                        getString(R.string.bmi),getString(R.string.status2),bmi)
                    imageViewBMI.setImageResource(R.drawable.normal)

                }else if(bmi >= 24.9){
                    textViewBMI.text = String.format("%s : %s (%.2f)",
                        getString(R.string.bmi),getString(R.string.status3),bmi)
                    imageViewBMI.setImageResource(R.drawable.over)

                }


            }else{
                if (editTextHeight.text.toString().isEmpty()){
                    editTextHeight.setError(getString(R.string.error))
                    return@setOnClickListener
                }else if(editTextWeight.text.toString().isEmpty()){
                    editTextWeight.setError(getString(R.string.error))
                    return@setOnClickListener
                }
            }
        }
        btnReset.setOnClickListener{
            editTextWeight.setText(getString(R.string.empty))
            editTextHeight.setText(getString(R.string.empty))
        }
    }
}