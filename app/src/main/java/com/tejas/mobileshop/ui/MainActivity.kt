package com.tejas.mobileshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tejas.mobileshop.databinding.ActivityMainBinding
import com.tejas.mobileshop.di.MainActivityComponent
import com.tejas.mobileshop.di.MobileShopApp
import com.tejas.mobileshop.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val viewBindingMainActivity get() = binding!!
    private lateinit var scrollActivityComponent: MainActivityComponent

    @Inject
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as MobileShopApp).onCreate()
        scrollActivityComponent =
                (applicationContext as MobileShopApp).applicationComponent.mainActivityComponent()
                        .create()
        scrollActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBindingMainActivity.root)
        setSupportActionBar(viewBindingMainActivity.toolbar)
    }

}