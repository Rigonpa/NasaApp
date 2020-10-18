package com.example.nasaapp.scenes.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.nasaapp.data.remote.Repository

class MainViewModel(private val context: Context): ViewModel() {
    //  Retrofit calls
    fun getPatentsAbout(element: String) {
        Repository.getPatentsAbout(element)
    }



    // Room calls
}