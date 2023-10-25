package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EcuacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecuacion)

        val EditvalA = findViewById<EditText>(R.id.editTextVala)
        val EditvalB = findViewById<EditText>(R.id.editTextValb)
        val EditvalC = findViewById<EditText>(R.id.editTextValc)
        val ButtonCalcular = findViewById<Button>(R.id.buttonSolucion)
        val viewRes = findViewById<TextView>(R.id.textViewResultado)

        ButtonCalcular.setOnClickListener{
            val a = EditvalA.text.toString().toFloatOrNull() ?: 0.0f
            val b = EditvalB.text.toString().toFloatOrNull() ?: 0.0f
            val c = EditvalC.text.toString().toFloatOrNull() ?: 0.0f

            val ecuacion = Ecuacion(a,b,c)
            viewRes.text = ecuacion.solucion()
        }
    }
}