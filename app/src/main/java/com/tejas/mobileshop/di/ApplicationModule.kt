package com.tejas.mobileshop.di

import com.tejas.mobileshop.api.ApiClient
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun provideApiClient() = ApiClient()
}