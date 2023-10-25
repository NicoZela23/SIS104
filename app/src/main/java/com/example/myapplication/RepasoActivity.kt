package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RepasoActivity : AppCompatActivity() {
    var dbHandler: BaseDatos2? = null
    var listTasks: List<Multiplicacion> = ArrayList<Multiplicacion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repaso)

        val editTextNumberA = findViewById<EditText>(R.id.editTextVala)
        val editTextNumberB = findViewById<EditText>(R.id.editTextValb)
        editTextNumberB.filters = arrayOf(InputFilter.LengthFilter(2)) // Limit input to 2 digits

        val textViewAA = findViewById<TextView>(R.id.textViewVala)
        val textViewBB = findViewById<TextView>(R.id.textViewValB)

        val textViewA = findViewById<TextView>(R.id.textViewVal)
        val textViewB = findViewById<TextView>(R.id.textViewVal2)

        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        val buttonMultiplicar = findViewById<Button>(R.id.buttonMultiplicar)
        val buttonBuscar = findViewById<Button>(R.id.buttonBuscarEcua)
        buttonMultiplicar.setOnClickListener {
            val numA = editTextNumberA.text.toString().toInt()
            val numB = editTextNumberB.text.toString().toInt()

            val digit1 = numB / 10
            val digit2 = numB % 10

            val result1 = numA * digit2
            textViewAA.text = result1.toString()

            val result2 = numA * digit1
            val result2String = (result2 * 10).toString()
            textViewBB.text = result2String.substring(0, result2String.length - 1)

            val finalResult = result1 + result2 * 10
            textViewResultado.text = finalResult.toString()

            textViewA.text = editTextNumberA.text
            textViewB.text = editTextNumberB.text

            dbHandler = BaseDatos2(this)
            var success: Boolean = false
            val multiplicacion: Multiplicacion = Multiplicacion()
            multiplicacion.num1 = editTextNumberA.text.toString().toInt()
            multiplicacion.num2 = editTextNumberB.text.toString().toInt()
            multiplicacion.resultado = textViewResultado.text.toString().toInt()
            success = dbHandler?.addLugar(multiplicacion) as Boolean
            listTasks = (dbHandler as BaseDatos2).lugar
            Log.d("Datos","--->" + listTasks[0].num1)
            for(multiplicacion in listTasks){
                Log.d("Datos","--->" + multiplicacion.num1 + " " + multiplicacion.id + " " + multiplicacion.num2 + " " + multiplicacion.resultado)
            }
            val toast = Toast.makeText(this@RepasoActivity, "Ingreso exitoso", Toast.LENGTH_SHORT)
            toast.show()
        }
        buttonBuscar.setOnClickListener(){
            val intent = Intent (this@RepasoActivity,BuscarActivity::class.java)
            startActivity(intent)
        }
    }
}