package com.example.nasaapp.data.model

import androidx.room.Entity
import java.io.Serializable
import com.google.gson.annotations.SerializedName

@Entity(tableName = "patent_table")
data class Patent(
    private val id: String,
    val name: String,
    val description: String,
    val imageUrlString: String
): Serializable