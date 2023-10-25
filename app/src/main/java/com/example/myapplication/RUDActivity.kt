package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RUDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var dbHandler: BaseDatos2? = null
        var listTasks: List<Multiplicacion> = ArrayList<Multiplicacion>()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rudactivity)
        val viewNum1CRUD = findViewById<EditText>(R.id.editTextNombreCRUD)
        val viewNum2CRUD = findViewById<EditText>(R.id.editTextDescripcionCRUD)
        val viewResultadoCRUD = findViewById<EditText>(R.id.editTextLatitudCRUD)

        val buttonEditDataCRUD = findViewById<Button>(R.id.buttonEditarCRUD)
        val buttonDeleteDataCRUD = findViewById<Button>(R.id.buttonEliminarCRUD)
        val buttonExit = findViewById<Button>(R.id.buttonReturnPage)

        val id = intent.getStringExtra("ID")
        //Funcion de retorno

        obtenerYMostrarLugar(id.toString().toInt())

        buttonEditDataCRUD.setOnClickListener() {
            dbHandler = BaseDatos2(this)
            var success: Boolean = false
            val lugares: Multiplicacion = Multiplicacion()

            success = false
            val multiplicacion2: Multiplicacion = Multiplicacion()
            multiplicacion2.id = id.toString().toInt()
            multiplicacion2.num1 = viewNum1CRUD.text.toString().toInt()
            multiplicacion2.num2 = viewNum2CRUD.text.toString().toInt()
            multiplicacion2.resultado = viewResultadoCRUD.text.toString().toInt()
            success = dbHandler?.updateLugar(multiplicacion2) as Boolean
            listTasks = (dbHandler as BaseDatos2).lugar
            val toast = Toast.makeText(this@RUDActivity, "Se edito correctamente", Toast.LENGTH_SHORT)
            toast.show()
        }
        buttonDeleteDataCRUD.setOnClickListener() {
            dbHandler = BaseDatos2(this)
            var success: Boolean = false
            success = false
            success = dbHandler?.deleteLugar(id.toString().toInt()) as Boolean
            listTasks = (dbHandler as BaseDatos2).lugar
            val toast = Toast.makeText(this@RUDActivity, "Se eliminar correctamente", Toast.LENGTH_SHORT)
            toast.show()
            borrarDatos()
            val intent = Intent(this@RUDActivity, BuscarActivity::class.java)
            startActivity(intent)
        }
        buttonExit.setOnClickListener() {
            val intent = Intent(this@RUDActivity, RepasoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun obtenerYMostrarLugar(id: Int) {
        val dbHandler = BaseDatos2(this)
        val multiplicacion = dbHandler.getLugar(id)

        val viewNum1CRUD = findViewById<EditText>(R.id.editTextNombreCRUD)
        val viewNum2CRUD = findViewById<EditText>(R.id.editTextDescripcionCRUD)
        val viewResultadoCRUD = findViewById<EditText>(R.id.editTextLatitudCRUD)

        viewNum1CRUD.setText(multiplicacion?.num1.toString())
        viewNum2CRUD.setText(multiplicacion?.num2.toString())
        viewResultadoCRUD.setText(multiplicacion?.resultado.toString())
        Log.d("Database Call", "ID: ${multiplicacion?.id}, num1: ${multiplicacion?.num1}, num2: ${multiplicacion?.num2}, resultado: ${multiplicacion?.resultado}")
    }
    private fun borrarDatos(){
        val viewNum1CRUD = findViewById<EditText>(R.id.editTextNombreCRUD)
        val viewNum2CRUD = findViewById<EditText>(R.id.editTextDescripcionCRUD)
        val viewResultadoCRUD = findViewById<EditText>(R.id.editTextLatitudCRUD)

        viewNum1CRUD.setText("")
        viewNum2CRUD.setText("")
        viewResultadoCRUD.setText("")
    }

}
