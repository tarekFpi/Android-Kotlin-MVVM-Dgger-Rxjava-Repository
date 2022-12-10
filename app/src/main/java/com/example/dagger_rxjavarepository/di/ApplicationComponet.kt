package com.example.dagger_rxjavarepository.di

import com.example.dagger_rxjavarepository.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponet {

    fun inject(activity: MainActivity)
}