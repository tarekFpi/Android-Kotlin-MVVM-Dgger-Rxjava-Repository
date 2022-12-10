package com.example.dagger_rxjavarepository.di

import android.app.Application

class Application_im :Application() {

    lateinit var applicationComponet: ApplicationComponet

    override fun onCreate() {
        super.onCreate()

      applicationComponet = DaggerApplicationComponet.builder().build()
    }

}