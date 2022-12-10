package com.example.dagger_rxjavarepository.retrofit

import com.example.mvvm_repository.model.productItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface Faker_Api {

    @GET("posts")
    fun getProduct() : Observable<List<productItem>>
}