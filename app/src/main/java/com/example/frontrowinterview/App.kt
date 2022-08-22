package com.example.frontrowinterview
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        var INSTANCE: App = App()
    }
    init {
        INSTANCE = this@App
    }
}