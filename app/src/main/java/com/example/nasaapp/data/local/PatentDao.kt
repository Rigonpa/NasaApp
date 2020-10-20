package com.example.nasaapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasaapp.data.model.Patent

@Dao
abstract class PatentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPatent(patent: Patent)

    @Query("SELECT * FROM patent_table")
    abstract fun getFavouritePatents(): LiveData<List<Patent>>
}