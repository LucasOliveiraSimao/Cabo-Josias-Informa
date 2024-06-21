package com.lucassimao.cabojosiasinforma

import android.app.Application
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Firebase.database.setPersistenceEnabled(true)
    }
}