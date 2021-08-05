package com.tejas.mobileshop.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exclusion(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val feature_id: String,
    val options_id: String
)