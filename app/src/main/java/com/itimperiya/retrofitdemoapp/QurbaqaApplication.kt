package com.itimperiya.retrofitdemoapp

import android.app.Application
import com.itimperiya.retrofitdemoapp.data.AppContainer
import com.itimperiya.retrofitdemoapp.data.DefaultAppContainer

class QurbaqaApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}