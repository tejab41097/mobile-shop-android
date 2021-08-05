package com.tejas.mobileshop.di

import com.tejas.mobileshop.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)
}