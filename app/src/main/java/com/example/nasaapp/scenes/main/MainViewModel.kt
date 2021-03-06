package com.example.nasaapp.scenes.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapp.data.model.Patent
import com.example.nasaapp.data.PatentsRepository

class MainViewModel(private val context: Context) : ViewModel() {
    private var patentsData = MutableLiveData<List<Patent>?>()

    //  Retrofit calls
    fun getPatentsAbout(element: String): MutableLiveData<List<Patent>?> {
        patentsData = PatentsRepository.getNewInstance().getPatentsAbout(element)
        return patentsData
    }


    // Room calls
    fun getFavouritePatents(): LiveData<List<Patent>> =
        PatentsRepository.getNewInstance().getFavouritePatents(context)

}