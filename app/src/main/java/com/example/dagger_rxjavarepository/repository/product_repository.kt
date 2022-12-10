package com.example.dagger_rxjavarepository.repository

import com.example.dagger_rxjavarepository.retrofit.Faker_Api
import com.example.mvvm_repository.model.productItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject


class product_repository @Inject constructor(private val fakerApi: Faker_Api) {

    fun getAllproductList(): Observable<List<productItem>> {
        return fakerApi.getProduct();
    }


}