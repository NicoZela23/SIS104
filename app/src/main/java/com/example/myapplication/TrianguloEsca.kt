package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class TrianguloEsca(context: Context?) : View(context) {

    private var tamaño: Float = 100000f // Tamaño inicial del triángulo

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.rgb(0, 0, 0) // Puedes ajustar el color aquí

        val path = Path()

        // Calcular el tamaño máximo para que el triángulo se ajuste dentro de la pantalla
        val tamañoMaximo = Math.min(width.toFloat(), height.toFloat())

        // Asegurarse de que el tamaño no sea mayor que el tamaño máximo
        tamaño = Math.min(tamaño, tamañoMaximo)

        // Puntos para el triángulo equilátero
        val x1 = width / 2f - tamaño / 2f
        val y1 = height / 2f + (tamaño / 2f) * (Math.sqrt(3.0) / 2).toFloat()

        val x2 = width / 2f
        val y2 = height / 2f - (tamaño / 2f) * (Math.sqrt(3.0) / 2).toFloat()

        val x3 = width / 2f + tamaño / 2f
        val y3 = height / 2f + (tamaño / 2f) * (Math.sqrt(3.0) / 2).toFloat()

        path.moveTo(x1, y1)
        path.lineTo(x2, y2)
        path.lineTo(x3, y3)
        path.close()

        canvas?.drawPath(path, paint)
    }
}


