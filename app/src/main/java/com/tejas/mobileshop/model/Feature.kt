package com.tejas.mobileshop.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Feature(
    @SerializedName("feature_id")
    @PrimaryKey(autoGenerate = false)
    var featureId: Int? = 0,
    var name: String?,
    @Ignore val options: List<Option>
) {
    constructor() : this(0, null, mutableListOf())
}