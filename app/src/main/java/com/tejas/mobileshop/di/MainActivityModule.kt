package com.tejas.mobileshop.di

import com.tejas.mobileshop.api.ApiClient
import com.tejas.mobileshop.api.ApiService
import dagger.Module
import dagger.Provides

@Module(subcomponents = [MainActivityComponent::class])
class MainActivityModule {

    @Provides
    fun apiService(apiClient: ApiClient): ApiService {
        return apiClient.getRetrofitInstance().create(ApiService::class.java)
    }
}