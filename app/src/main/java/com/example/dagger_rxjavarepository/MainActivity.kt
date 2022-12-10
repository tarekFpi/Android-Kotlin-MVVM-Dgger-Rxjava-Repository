package com.example.dagger_rxjavarepository

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dagger_rxjavarepository.di.Application_im
import com.example.dagger_rxjavarepository.viewModel.ProductFactory
import com.example.dagger_rxjavarepository.viewModel.ProductViewModel


import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: ProductViewModel

    @Inject
    lateinit var productfactory: ProductFactory

    lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById<TextView>(R.id.text_data)

    //    Toast.makeText(applicationContext,"show",Toast.LENGTH_SHORT).show()

         (application as Application_im).applicationComponet.inject(this)

        mainViewModel = ViewModelProvider(this,productfactory).get(ProductViewModel::class.java)

        mainViewModel.productList.observe(this,{

            textView.text=it.joinToString {
                    x -> x.body +"/n/n"
            }
        })

        mainViewModel.errorMessage.observe(this, Observer {

            Toast.makeText(this, "Error $it", Toast.LENGTH_SHORT).show()
        })
    }
}




