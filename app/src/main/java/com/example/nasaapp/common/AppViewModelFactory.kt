package com.example.nasaapp.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapp.scenes.detail.DetailViewModel
import com.example.nasaapp.scenes.main.MainViewModel

class AppViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) -> MainViewModel(application)
                isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(application)
                else -> throw IllegalArgumentException()
            }
        } as T
    }
}
