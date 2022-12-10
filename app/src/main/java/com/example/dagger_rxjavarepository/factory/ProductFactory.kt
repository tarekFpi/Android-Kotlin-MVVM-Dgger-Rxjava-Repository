package com.example.dagger_rxjavarepository.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_rxjavarepository.repository.product_repository
import javax.inject.Inject

class ProductFactory @Inject constructor(private val productRepository: product_repository):
    ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }
}