package com.example.nasaapp.data.remote

import androidx.lifecycle.MutableLiveData
import com.example.nasaapp.data.model.NasaResponse
import com.example.nasaapp.data.model.Patent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.IllegalArgumentException

class PatentsRepository {

    companion object {
        fun getNewInstance() = PatentsRepository()
    }


    fun getPatentsAbout(element: String): MutableLiveData<List<Patent>> {
        val patentsData = MutableLiveData<List<Patent>>()
        RetrofitService().patentApi.getPatents(element, "DEMO_KEY").enqueue(object : Callback<NasaResponse> {
            override fun onResponse(call: Call<NasaResponse>, response: Response<NasaResponse>) {
                if (response.isSuccessful && response.body() != null) {
                   patentsData.value = loadPatentsArray((response.body() as NasaResponse).results!!)
                }
            }

            override fun onFailure(call: Call<NasaResponse>, t: Throwable) {
                patentsData.value = null
            }
        })

        return patentsData
    }

    private fun loadPatentsArray(results: List<String?>): List<Patent> {
        throw IllegalArgumentException()
    }
}