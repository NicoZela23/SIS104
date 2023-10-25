package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val buttonGraficos = findViewById<Button>(R.id.buttonGraficos)
        val buttonGraficosPrueba = findViewById<Button>(R.id.buttonGraficosPrueba)
        val buttonDataBase = findViewById<Button>(R.id.buttonDataBase)
        val buttonEcuacion = findViewById<Button>(R.id.buttonEcuacion)
        val buttonCalculadoraNormal = findViewById<Button>(R.id.buttonCalculadoraNormal)
        val buttonConsumeWebService = findViewById<Button>(R.id.buttonConsumirSimple)
        val buttonCRUDWS = findViewById<Button>(R.id.buttonWebServiceCrud)
        val buttonRepaso = findViewById<Button>(R.id.buttonRepaso)
        val buttonExit = findViewById<Button>(R.id.buttonExit)


        buttonCalculadora.setOnClickListener(){
            val intent = Intent (this@MainActivity,CalculadoraActivity::class.java)
            startActivity(intent)
        }
        buttonGraficos.setOnClickListener(){
            val intent = Intent (this@MainActivity,GraficosActivity::class.java)
            startActivity(intent)
        }
        buttonGraficosPrueba.setOnClickListener(){
            val graficosPR = Graficos(this)
            setContentView(graficosPR)
        }
        buttonDataBase.setOnClickListener(){
            val intent = Intent (this@MainActivity,DataBaseActivity::class.java)
            startActivity(intent)
        }
        buttonEcuacion.setOnClickListener(){
            val intent = Intent (this@MainActivity,EcuacionActivity::class.java)
            startActivity(intent)
        }
        buttonCalculadoraNormal.setOnClickListener(){
            val intent = Intent (this@MainActivity,CalculadoraClasicaActivity::class.java)
            startActivity(intent)
        }
        buttonConsumeWebService.setOnClickListener(){
            val retrofitGET = RetrofitClient.webServiceAPI.getAlbum()

            retrofitGET.enqueue(object : Callback<Album>{
                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    val Respuesta: String = response.body().toString()
                    val toast = Toast.makeText(this@MainActivity, Respuesta, Toast.LENGTH_SHORT)
                    toast.show()
                }

                override fun onFailure(call: Call<Album>, t: Throwable) {
                    val toast = Toast.makeText(this@MainActivity, "Error de conexion", Toast.LENGTH_SHORT)
                    toast.show()
                }
            })
        }
        buttonRepaso.setOnClickListener(){
            val intent = Intent (this@MainActivity,RepasoActivity::class.java)
            startActivity(intent)
        }
        buttonExit.setOnClickListener(){
            finish()
        }
    }
}

