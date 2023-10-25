package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.view.View

class Colores(context: Context?) : View(context) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.WHITE)
        val paint = Paint()

        val colors = arrayOf(
            Color.rgb(255, 0, 0),
            Color.rgb(255, 95, 0),
            Color.rgb(255, 127, 0),
            Color.rgb(255, 159, 0),
            Color.rgb(0, 95, 255),
            Color.rgb(0, 127, 255),
            Color.rgb(0, 159, 255),
            Color.rgb(0, 191, 255),
            Color.rgb(0, 223, 255),
            Color.rgb(0, 255, 255)// Caliente
        )

        val width: Int = context?.resources?.displayMetrics?.widthPixels ?: 0
        val height: Int = context?.resources?.displayMetrics?.heightPixels ?: 0

        val centerX = width / 2f
        val centerY = height / 2f

        for (i in 10 downTo 1) {
            val path = Path()
            path.moveTo(centerX, centerY - 50f * i)
            path.lineTo(centerX - 50f * i, centerY + 50f * i)
            path.lineTo(centerX + 50f * i, centerY + 50f * i)
            path.close()

            paint.color = colors[10 - i]
            canvas?.drawPath(path, paint)
        }
    }
}

