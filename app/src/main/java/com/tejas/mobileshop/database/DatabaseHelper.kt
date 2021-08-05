package com.tejas.mobileshop.database

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class DatabaseHelper @Inject constructor(context: Context) {
    private val db = Room.databaseBuilder(context, Database::class.java, "MOBILE_DB")
        .fallbackToDestructiveMigration()
        .build()

    fun getDatabase() = db

    fun clearDatabase() = db.clearAllTables()
}