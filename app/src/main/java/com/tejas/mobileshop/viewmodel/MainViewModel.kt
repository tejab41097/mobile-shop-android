package com.tejas.mobileshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tejas.mobileshop.model.BaseModel
import com.tejas.mobileshop.model.Feature
import com.tejas.mobileshop.repository.MainRepository
import com.tejas.mobileshop.util.Coroutine
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getData(): LiveData<List<Feature>> {
        val mutableLiveData = MutableLiveData<List<Feature>>()
        Coroutine.ioThenIO({
            try {
                mainRepository.getData()
            } catch (ex: Exception) {
                null
            }
        }, {
            if (it?.isSuccessful == true) {
                val model = it.body() as BaseModel
                mutableLiveData.postValue(model.features)
            } else {
                it?.errorBody().toString()
            }
        })
        return mutableLiveData
    }
}