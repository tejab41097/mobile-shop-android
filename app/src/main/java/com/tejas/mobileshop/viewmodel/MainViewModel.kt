package com.tejas.mobileshop.viewmodel

import androidx.lifecycle.ViewModel
import com.tejas.mobileshop.database.Database
import com.tejas.mobileshop.model.BaseModel
import com.tejas.mobileshop.repository.MainRepository
import com.tejas.mobileshop.util.Coroutine
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val database: Database
) : ViewModel() {

    init {
        getData()
    }

    private fun getData() {
        Coroutine.ioThenIO({
            try {
                mainRepository.getData()
            } catch (ex: Exception) {
                null
            }
        }, {
            if (it?.isSuccessful == true) {
                val model = it.body() as BaseModel
                database.getBaseDao().saveAllFeatures(model)
            } else
                it?.errorBody().toString()
        })
    }

    fun getAllMobiles() = database.getBaseDao().getFeatureById(1)
}