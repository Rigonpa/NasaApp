package com.example.nasaapp.data.remote

import com.example.nasaapp.data.model.NasaResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PatentsApi {

    @GET("techtransfer/patent")
    @Headers("Content-Type: application/json")
    fun getPatents(@Query("word") element: String, @Query("api_key") apiKey: String): Call<NasaResponse>
}