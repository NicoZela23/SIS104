package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calcuejemplo.Graficador

class GraficosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graficos)

        val buttonColores = findViewById<Button>(R.id.buttonTrianguloColor)
        val buttonTescala = findViewById<Button>(R.id.buttonTrianguloEscala)
        val buttonCescala = findViewById<Button>(R.id.buttonCuadradoEscala)
        val buttonGraficador = findViewById<Button>(R.id.buttonGraficador)
        val buttonReturn = findViewById<Button>(R.id.buttonReturn)

        buttonColores.setOnClickListener(){
            val TrianguloColores = Colores(this)
            setContentView(TrianguloColores)
        }
        buttonTescala.setOnClickListener(){
            val TrianguloEscala = TrianguloEsca(this)
            setContentView(TrianguloEscala)
        }
        buttonCescala.setOnClickListener(){
            val CuadradoEscala = CuadradoEsca(this)
            setContentView(CuadradoEscala)
        }
        buttonGraficador.setOnClickListener(){
            val Graficador = Graficador(this)
            setContentView(Graficador)
        }
        buttonReturn.setOnClickListener(){
            finish()
        }
    }
}