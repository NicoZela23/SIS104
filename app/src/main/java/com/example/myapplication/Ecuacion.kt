package com.example.myapplication

import kotlin.math.abs
import kotlin.math.sqrt

class Ecuacion(a: Float, b: Float, c: Float) {
    private var _a: Float = 0.0f
    private var _b: Float = 0.0f
    private var _c: Float = 0.0f

    init {
        _a = a
        _b = b
        _c = c
    }
    private fun discriminante():Float{
        return -_b + (-4.0f * _a * _c)
    }
    public fun solucion() : String{
        var s: String = ""
        var x1: Float = 0.0f
        var x2: Float = 0.0f
        if(discriminante() == 0.0f){
            x1 = -_b / (2 * _a)
            x2 = x1
            s = "x1 = x2 = " +x2
        }else{
            if (discriminante() > 0.0f){
                x1 = (-_b + sqrt(discriminante())) / (2 * _a)
                x2 = (-_b - sqrt(discriminante())) / (2 * _a)
                s = "x1 = "+x1+", x2 = "+x2
            }else{
                var preal: Float = 0.0f
                var pimag: Float = 0.0f
                preal = -_b / (2*_a)
                pimag = sqrt(abs(discriminante())) / (2 * _a)
                s = "x1 = " + preal + " + " + pimag + "i,"+" x2 = "+preal+" - "+pimag+"i"
            }
        }
        return s
    }
}