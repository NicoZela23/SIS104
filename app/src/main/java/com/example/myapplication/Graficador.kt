package com.example.calcuejemplo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View

class Graficador(context: Context) : View(context) {

    private val TAG = "DATOS"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.BLACK)
        val paint = Paint()
        paint.color = Color.WHITE

        val ancho = width
        val alto = height
        Log.d(TAG, "Ancho = $ancho Alto = $alto")

        canvas.drawLine(0f, alto / 2f, ancho.toFloat(), alto / 2f, paint)
        canvas.drawLine(ancho / 2f, 0f, ancho / 2f, alto.toFloat(), paint)

        val limInx = -20f
        val limSupx = 20f
        val limIny = -20f
        val limSupy = 20f

        var x = limInx
        while (x <= limSupx) {
            val y = fx(x)
            val xt = ((x - limInx) / (limSupx - limInx)) * ancho
            val yt = alto - ((y - limIny) / (limSupy - limIny)) * alto
            canvas.drawCircle(xt, yt.toFloat(), 5f, paint)
            Log.d(TAG, "x = $x xt = $xt")
            x += 0.01f
        }
    }

    private fun fx(x: Float): Double {
        //return x * Math.sin(x.toDouble())
        //return Math.tan(x.toDouble())
       //return Math.asin(x.toDouble())
        //return Math.acos(x.toDouble())
        return Math.atan(x.toDouble())
        //return Math.log(x.toDouble())
        //return Math.cosh(x.toDouble())
        //return Math.sinh(x.toDouble())
    }
}
