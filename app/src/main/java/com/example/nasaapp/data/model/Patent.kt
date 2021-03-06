package com.example.nasaapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "patent_table")
data class Patent(
    @PrimaryKey
    val id: String,
    val name: String,
    val description: String,
    val imageUrlString: String
): Serializable