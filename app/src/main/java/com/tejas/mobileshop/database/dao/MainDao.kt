package com.tejas.mobileshop.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tejas.mobileshop.model.BaseModel
import com.tejas.mobileshop.model.Exclusion
import com.tejas.mobileshop.model.Feature
import com.tejas.mobileshop.model.Option

@Dao
interface MainDao {
    @Transaction
    suspend fun saveAllFeatures(model: BaseModel) {
        insertAllFeatures(model.features)
        model.features.forEach { feature ->
            feature.options.forEach {
                it.parentId = feature.featureId
            }
            insertAllOptions(feature.options)
        }
        model.exclusions.forEach {
            insertAllExclusions(it)
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllOptions(list: List<Option>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFeatures(list: List<Feature>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllExclusions(list: List<Exclusion>)

    @Transaction
    @Query("SELECT * FROM OPTION WHERE parentId=:parentId")
    fun getFeatureById(parentId: Int): LiveData<MutableList<Option>>

//    @Query("SELECT * FROM Feature Where featureId=:id")
//    suspend fun getOnlyFeaturesById(id: Int): LiveData<Feature>
//
//    @Query("SELECT * FROM Option Where parentId=:id")
//    suspend fun getOptionsByFeatureId(id: Int): MutableList<Option>


}