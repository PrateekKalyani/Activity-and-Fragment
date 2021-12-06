package com.example.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityMainBinding
import com.example.retrofitapplication.network.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val productList  = mutableListOf<ProductModel>()
    private val viewModel by lazy {ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ProductViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
        setProductList()
    }

    private fun setRecyclerView() {

        println("prouduct list ${productList}")


        binding.productRecyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(
                productList = productList
            )
        }

    }

    private fun setProductList() {

        viewModel.productList.observe(this, Observer {list ->
            if (list != null) {
                productList.addAll(list)
                binding.productRecyclerView.adapter!!.notifyDataSetChanged()
            }
        })

    }
}