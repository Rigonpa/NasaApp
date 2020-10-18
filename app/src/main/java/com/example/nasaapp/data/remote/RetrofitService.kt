package com.example.nasaapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val patentApi: PatentsApi
    init {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        patentApi = retrofit.create(PatentsApi::class.java)
    }
}