package com.example.myapplication

class Operaciones {
    var a: Int = 0
    var b: Int = 0

    fun suma(): Int {
        return a + b
    }

    fun resta(): Int {
        return a - b
    }

    fun multiplicacion(): Int {
        return a * b
    }

    fun division(): Float {
        return a.toFloat() / b.toFloat()
    }
}