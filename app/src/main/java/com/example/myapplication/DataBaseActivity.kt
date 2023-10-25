package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class DataBaseActivity : AppCompatActivity() {
    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base)
        val buttonCreate = findViewById<Button>(R.id.buttonIngresarLugar)
        val buttonSearch = findViewById<Button>(R.id.buttonBuscarLugar)
        val buttonReturn = findViewById<Button>(R.id.buttonExit)

        buttonCreate.setOnClickListener(){
            val intent = Intent (this@DataBaseActivity,CreateActivity::class.java)
            startActivity(intent)
        }
        buttonSearch.setOnClickListener(){
            val intent = Intent (this@DataBaseActivity,BuscarActivity::class.java)
            startActivity(intent)
        }
        buttonReturn.setOnClickListener(){
            val intent = Intent (this@DataBaseActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }

}
