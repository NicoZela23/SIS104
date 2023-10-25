package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculadoraClasicaActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private var input = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_clasica)

        textView = findViewById(R.id.textView)
        setupNumberButtons()
    }

    private fun setupNumberButtons() {
        val numberButtonIds = listOf(R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9)

        numberButtonIds.forEach { id ->
            val button = findViewById<Button>(id)
            button.setOnClickListener {
                val digit = button.text.toString()
                input.append(digit)
                textView.text = input.toString()
            }
        }

        // Operadores y botón de igual
        val operators = listOf('+', '-', '×', '÷')
        operators.forEach { operator ->
            val button = findViewById<Button>(getOperatorButtonId(operator))
            button.setOnClickListener {
                input.append(operator)
                textView.text = input.toString()
            }
        }

        // Botón de igual (=)
        val equalsButton = findViewById<Button>(R.id.buttonigual)
        equalsButton.setOnClickListener {
            try {
                val result = eval(input.toString())
                textView.text = result.toString()
                input.clear()
                input.append(result.toString())
            } catch (e: Exception) {
                textView.text = "Error"
            }
        }

        // Botón de limpiar (C)
        val clearButton = findViewById<Button>(R.id.buttonclear)
        clearButton.setOnClickListener {
            input.clear()
            textView.text = ""
        }
    }

    private fun getOperatorButtonId(operator: Char): Int {
        return when (operator) {
            '+' -> R.id.buttonSuma
            '-' -> R.id.buttonmenos
            '×' -> R.id.buttonmulti
            '÷' -> R.id.buttondivi
            else -> throw IllegalArgumentException("Operador no válido: $operator")
        }
    }

    private fun eval(expression: String): Double {
        return when {
            expression.contains('+') -> {
                val parts = expression.split('+')
                parts[0].toDouble() + parts[1].toDouble()
            }
            expression.contains('-') -> {
                val parts = expression.split('-')
                parts[0].toDouble() - parts[1].toDouble()
            }
            expression.contains('×') -> {
                val parts = expression.split('×')
                parts[0].toDouble() * parts[1].toDouble()
            }
            expression.contains('÷') -> {
                val parts = expression.split('÷')
                parts[0].toDouble() / parts[1].toDouble()
            }
            else -> throw IllegalArgumentException("Expresión no válida: $expression")
        }
    }
}

