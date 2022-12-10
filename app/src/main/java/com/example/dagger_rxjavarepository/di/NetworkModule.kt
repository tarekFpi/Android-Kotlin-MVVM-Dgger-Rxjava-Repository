package com.example.dagger_rxjavarepository.di

import com.example.dagger_rxjavarepository.retrofit.Faker_Api
import com.example.dagger_rxjavarepository.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun  providerRetrofit() :Retrofit{

        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }


    @Singleton
    @Provides
    fun  providerFakerApi(retrofit: Retrofit) : Faker_Api {
        return retrofit.create(Faker_Api::class.java)
    }
}