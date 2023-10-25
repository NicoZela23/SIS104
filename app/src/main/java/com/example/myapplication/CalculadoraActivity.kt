package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        val buttonMultiplicar = findViewById<Button>(R.id.buttonMulti)
        val buttonRestar = findViewById<Button>(R.id.buttonResta)
        val buttonDividir = findViewById<Button>(R.id.buttonDivi)
        val buttonSumar = findViewById<Button>(R.id.buttonSuma)
        val viewA = findViewById<EditText>(R.id.editTextVala)
        val viewB = findViewById<EditText>(R.id.editTextValb)
        val viewRes = findViewById<TextView>(R.id.textViewResultado)

        buttonSumar.setOnClickListener {
            val oper = Operaciones()
            oper.a = Integer.parseInt(viewA.text.toString())
            oper.b = Integer.parseInt(viewB.text.toString())
            viewRes.text = oper.suma().toString()
        }

        buttonRestar.setOnClickListener {
            val oper = Operaciones()
            oper.a = Integer.parseInt(viewA.text.toString())
            oper.b = Integer.parseInt(viewB.text.toString())
            viewRes.text = oper.resta().toString()
        }

        buttonDividir.setOnClickListener {
            val oper = Operaciones()
            oper.a = Integer.parseInt(viewA.text.toString())
            oper.b = Integer.parseInt(viewB.text.toString())
6
            if (oper.a == 0 || oper.b == 0) {
                viewRes.text = "Invalido"
            } else {
                viewRes.text = oper.division().toString()
            }
        }

        buttonMultiplicar.setOnClickListener {
            val oper = Operaciones()
            oper.a = Integer.parseInt(viewA.text.toString())
            oper.b = Integer.parseInt(viewB.text.toString())
            viewRes.text = oper.multiplicacion().toString()
        }

    }
}