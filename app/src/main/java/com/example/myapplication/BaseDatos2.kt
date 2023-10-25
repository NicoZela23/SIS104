package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BaseDatos2(context: Context): SQLiteOpenHelper(context,BaseDatos2.NOMBRE_BASE_DATOS,null,BaseDatos2.VERSION_BASE_DATOS) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREAR_TABLA = "CREATE TABLE $NOMBRE_TABLA ($ID INTEGER PRIMARY KEY AUTOINCREMENT,$NUM1 INTEGER,$NUM2 INTEGER,$RESULTADO INTEGER);"
        db?.execSQL(CREAR_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val BORRAR_TABLA = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(BORRAR_TABLA)
        onCreate(db)
    }

    fun addLugar(multiplicacion: Multiplicacion):Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NUM1,multiplicacion.num1)
        values.put(NUM2,multiplicacion.num2)
        values.put(RESULTADO,multiplicacion.resultado)
        val _success = db.insert(NOMBRE_TABLA,null,values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    @SuppressLint("Range")
    fun getLugar(_id: Int): Multiplicacion? {
        val multiplicacion = Multiplicacion()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA WHERE $ID = $_id"
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                multiplicacion.id = cursor.getInt(cursor.getColumnIndex(ID))
                multiplicacion.num1 = cursor.getInt(cursor.getColumnIndex(NUM1))
                multiplicacion.num2 = cursor.getInt(cursor.getColumnIndex(NUM2))
                multiplicacion.resultado = cursor.getInt(cursor.getColumnIndex(RESULTADO))
            }
            cursor.close()
        }

        // Retorna null si no se encuentra ningún lugar con el ID
        return if (multiplicacion.id != 0) multiplicacion else null
    }


    val lugar: List<Multiplicacion> @SuppressLint("Range")
    get(){
        val multiplicacionList = ArrayList<Multiplicacion>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $NOMBRE_TABLA"
        val cursor = db.rawQuery(selectQuery, null)
        if(cursor != null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                val multiplicacion = Multiplicacion()
                multiplicacion.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                multiplicacion.num1 = cursor.getInt(cursor.getColumnIndex(NUM1))
                multiplicacion.num2 = cursor.getInt(cursor.getColumnIndex(NUM2))
                multiplicacion.resultado = cursor.getInt(cursor.getColumnIndex(RESULTADO))
                multiplicacionList.add(multiplicacion)
            }
        }
        cursor.close()
        return multiplicacionList
    }

    fun updateLugar(multiplicacion: Multiplicacion): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NUM1,multiplicacion.num1)
        values.put(NUM2,multiplicacion.num2)
        values.put(RESULTADO,multiplicacion.resultado)
        val _success = db.update(NOMBRE_TABLA,values,ID+"=?",arrayOf(multiplicacion.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteLugar(_id: Int): Boolean{
        val db = this.writableDatabase
        val _success = db.delete(NOMBRE_TABLA,ID+"=?",arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    fun deleteAllMultis(): Boolean {
        val db = this.writableDatabase
        val _success = db.delete(NOMBRE_TABLA, null, null).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    companion object{
        private val VERSION_BASE_DATOS = 1
        private val NOMBRE_BASE_DATOS = "dbsis104Multi1"
        private val NOMBRE_TABLA = "calculos"
        private val ID = "id"
        private val NUM1 = "num1"
        private val NUM2 = "num2"
        private val RESULTADO = "resultado"
    }
}