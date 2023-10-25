package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BuscarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)
        val viewIdPlace = findViewById<EditText>(R.id.editTextFindPlace)
        val buttonSendData = findViewById<Button>(R.id.buttonFindPlace)
        val buttonExit = findViewById<Button>(R.id.buttonReturnMain)

        buttonSendData.setOnClickListener{
            val id = viewIdPlace.text.toString()
            val intent = Intent (this@BuscarActivity,RUDActivity::class.java)
            intent.putExtra("ID",id)
            startActivity(intent)
        }
        buttonExit.setOnClickListener{
            val intent = Intent (this@BuscarActivity,DataBaseActivity::class.java)
            startActivity(intent)
        }
    }
}