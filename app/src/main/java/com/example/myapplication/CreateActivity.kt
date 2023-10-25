package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateActivity : AppCompatActivity() {
    var dbHandler: BaseDatos2? = null
    var listTasks: List<Multiplicacion> = ArrayList<Multiplicacion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        val viewNum1 = findViewById<EditText>(R.id.editTextNombre)
        val viewNum2 = findViewById<EditText>(R.id.editTextDescripcion)
        val viewResultado = findViewById<EditText>(R.id.editTextLatitud)

        val buttonSendData = findViewById<Button>(R.id.buttonSendDataBD)
        val buttonExit = findViewById<Button>(R.id.buttonReturn)

        buttonSendData.setOnClickListener(){
            dbHandler = BaseDatos2(this)
            var success: Boolean = false
            val multiplicacion: Multiplicacion = Multiplicacion()
            multiplicacion.num1 = viewNum1.text.toString().toInt()
            multiplicacion.num2 = viewNum2.text.toString().toInt()
            multiplicacion.resultado = viewResultado.text.toString().toInt()
            success = dbHandler?.addLugar(multiplicacion) as Boolean
            listTasks = (dbHandler as BaseDatos2).lugar
            Log.d("Datos","--->" + listTasks[0].num1)
            for(multiplicacion in listTasks){
                Log.d("Datos","--->" + multiplicacion.num1 + " " + multiplicacion.id + " " + multiplicacion.num2 + " " + multiplicacion.resultado)
            }
            val toast = Toast.makeText(this@CreateActivity, "Ingreso exitoso", Toast.LENGTH_SHORT)
            toast.show()
        }


        buttonExit.setOnClickListener(){
            val intent = Intent (this@CreateActivity,DataBaseActivity::class.java)
            startActivity(intent)
        }
    }
}