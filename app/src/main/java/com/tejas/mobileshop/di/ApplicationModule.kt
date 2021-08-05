package com.tejas.mobileshop.di

import android.content.Context
import androidx.annotation.NonNull
import com.tejas.mobileshop.api.ApiClient
import com.tejas.mobileshop.database.Database
import com.tejas.mobileshop.database.DatabaseHelper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun provideApiClient() = ApiClient()

    @Provides
    fun provideDbHelper(@NonNull context: Context): Database {
        return DatabaseHelper(context).getDatabase()
    }

}