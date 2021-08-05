package com.tejas.mobileshop.repository

import com.tejas.mobileshop.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private var apiService: ApiService
){

    suspend fun getData() = apiService.getData()

}