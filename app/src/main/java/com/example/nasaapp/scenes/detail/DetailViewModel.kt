package com.example.nasaapp.scenes.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.nasaapp.data.PatentsRepository
import com.example.nasaapp.data.model.Patent

class DetailViewModel(private val application: Application): ViewModel() {

    fun savePatent(patent: Patent) {
        PatentsRepository.getNewInstance().savePatent(patent, application.applicationContext)
    }
}