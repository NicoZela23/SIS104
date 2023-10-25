package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface WebServiceAPI {
    @GET("primer.php")
    fun getPersona(): Call<Person>

    @GET("albums")
    fun getAlbum(): Call<Album>
}