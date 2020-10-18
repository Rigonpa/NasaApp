package com.example.nasaapp.data

import com.example.nasaapp.data.model.Patent

interface

class Repository {
    fun getPatentsAbout(element: String, completion: ((List<Patent>) -> Unit)) {}
}