package com.example.nasaapp.data.model

import java.io.Serializable
import com.google.gson.annotations.SerializedName

data class Patent(
    private val id: String,
    val name: String,
    val description: String,
    val imageUrlString: String
): Serializable