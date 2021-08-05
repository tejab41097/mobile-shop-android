package com.tejas.mobileshop.api

import com.tejas.mobileshop.model.BaseModel
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("/mhrpatel12/esper-assignment/db")
    suspend fun getData(): Response<BaseModel>
}