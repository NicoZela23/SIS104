package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class CuadradoEsca(context: Context) : View(context) {

    private var base: Float = 67000f // Ancho inicial del rectángulo

    private var altura: Float = base / 2 // Alto inicial del rectángulo
    private var escala: Float = base/(base*74f) // Factor de escala inicial
    private var paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.rgb(0, 0, 0) // Puedes ajustar el color aquí

        // Obtener el tamaño máximo para que el rectángulo se ajuste dentro de la pantalla
        val anchoMaximo = width.toFloat()
        val altoMaximo = height.toFloat()

        // Calcular el ancho y alto del rectángulo según las dimensiones actuales y la escala
        val anchoRectangulo = base * escala
        val altoRectangulo = altura * escala

        // Calcular las coordenadas de la esquina superior izquierda del rectángulo
        val x1 = (anchoMaximo - anchoRectangulo) / 2
        val y1 = (altoMaximo - altoRectangulo) / 2

        val rectangulo = RectF(x1, y1, x1 + anchoRectangulo, y1 + altoRectangulo)

        canvas?.drawRect(rectangulo, paint)
    }

    fun setEscala(escala: Float) {
        // Asegurarse de que la escala esté dentro de un rango adecuado (puedes ajustar los límites)
        this.escala = escala.coerceIn(0.1f, 1.0f)
        // Llamar a invalidate() para volver a dibujar la vista con la nueva escala
        invalidate()
    }

    fun setBase(base: Float) {
        this.base = base
        invalidate()
    }

    fun setAltura(altura: Float) {
        this.altura = altura
        invalidate()
    }

    fun getBase(): Float {
        return base
    }

    fun getAltura(): Float {
        return altura
    }
}






