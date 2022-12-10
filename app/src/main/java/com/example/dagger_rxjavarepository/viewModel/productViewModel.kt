package com.example.dagger_rxjavarepository.viewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger_rxjavarepository.repository.product_repository
import com.example.mvvm_repository.model.productItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val productRepository: product_repository) :
    ViewModel(){

    var productList = MutableLiveData<List<productItem>>()

    val errorMessage = MutableLiveData<String>()

    private val compositeDisposable = CompositeDisposable()

    init {
        fetch_product()
    }

    fun fetch_product() {

        val response = productRepository.getAllproductList()
        compositeDisposable.add(
            response
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ itemlist ->
                    productList.postValue(itemlist)
                }, {
                    errorMessage.postValue(it.message)
                })

        )
    }
}