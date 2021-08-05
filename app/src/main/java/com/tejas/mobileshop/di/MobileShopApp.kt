package com.tejas.mobileshop.di

import android.app.Application

class MobileShopApp : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        applicationComponent =
            DaggerApplicationComponent.factory().create(applicationContext)
        super.onCreate()
    }
}