package com.tejas.mobileshop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tejas.mobileshop.database.dao.MainDao
import com.tejas.mobileshop.model.Exclusion
import com.tejas.mobileshop.model.Feature
import com.tejas.mobileshop.model.Option

@Database(
    entities = [Feature::class, Option::class, Exclusion::class],
    version = 1,
    exportSchema = true
)
abstract class Database : RoomDatabase() {

    abstract fun getBaseDao(): MainDao
}