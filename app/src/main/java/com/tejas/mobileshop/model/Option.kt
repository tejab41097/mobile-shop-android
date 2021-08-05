package com.tejas.mobileshop.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Option(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var icon: String,
    var parentId: Int?
)