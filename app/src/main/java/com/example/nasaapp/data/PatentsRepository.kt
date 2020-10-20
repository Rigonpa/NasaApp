package com.example.nasaapp.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nasaapp.data.local.PatentRoomDatabase
import com.example.nasaapp.data.model.NasaResponse
import com.example.nasaapp.data.model.Patent
import com.example.nasaapp.data.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PatentsRepository {

    companion object {
        fun getNewInstance() = PatentsRepository()
    }

    // Room - Local database
    fun savePatent(patent: Patent, context: Context) {
        PatentRoomDatabase.getNewInstance(context).patentDao().insertPatent(patent)
    }

    fun getFavouritePatents(context: Context): LiveData<List<Patent>> =
        PatentRoomDatabase.getNewInstance(context).patentDao().getFavouritePatents()


    // Retrofit - NASA API
    fun getPatentsAbout(element: String): MutableLiveData<List<Patent>?> {
        var patentsData = MutableLiveData<List<Patent>?>()
        RetrofitService().patentApi.getPatents(element, "DEMO_KEY")
            .enqueue(object : Callback<NasaResponse> {
                override fun onResponse(
                    call: Call<NasaResponse>,
                    response: Response<NasaResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        patentsData.value =
                            loadPatentsArray((response.body() as NasaResponse).results)
                    }
                }

                override fun onFailure(call: Call<NasaResponse>, t: Throwable) {
                    patentsData.value = null
                }
            })

        return patentsData
    }

    private fun loadPatentsArray(results: List<List<String>>?): List<Patent>? {
        return if (results != null) {
            var patents = results.map {
                if (correctUrlString(it[10])) {
                    Patent(it[0], it[2], it[3], it[10])
                } else {
                    null
                }
            }
            patents.filterNotNull()

        } else null
    }

    private fun correctUrlString(urlString: String): Boolean {
        return !urlString.contains(" ")
    }
}


//        val patentsList = results.map {
//            if (it != null && correctUrlString(it[10]))
//                Patent(it[0], it[2], it[3], it[10])
//        }
//        return patentsList