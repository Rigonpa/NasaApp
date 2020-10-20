package com.example.nasaapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nasaapp.data.model.Patent

@Database(entities = [Patent::class], version = 1, exportSchema = false)
abstract class PatentRoomDatabase : RoomDatabase() {

    abstract fun patentDao(): PatentDao

    companion object {
        private var instance: PatentRoomDatabase? = null
        fun getNewInstance(context: Context): PatentRoomDatabase {
            if (instance == null) {
                synchronized(PatentRoomDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PatentRoomDatabase::class.java,
                        "patent_db"
                    )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance!!
        }
    }
}