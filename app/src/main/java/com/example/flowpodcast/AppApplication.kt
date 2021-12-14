package com.example.flowpodcast

import android.app.Application
import android.content.Context
import com.example.flowpodcast.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(viewModelModule)
        }
    }
}