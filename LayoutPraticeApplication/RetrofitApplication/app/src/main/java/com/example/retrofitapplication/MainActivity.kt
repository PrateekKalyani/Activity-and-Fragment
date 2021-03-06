package com.example.retrofitapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var productList = mutableListOf<ProductModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setRecyclerView()
        getProductData()
    }

    private fun setRecyclerView() {
        binding.productRecyclerView.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ProductAdapter(
                context = this@MainActivity,
                productList = productList
            )
        }
    }

    private fun getProductData() {

        val apiInterface = ApiService.create().getData()

        apiInterface.enqueue( object : Callback<List<ProductModel>> {

            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                productList.addAll(response.body()!!)
                binding.productRecyclerView.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {

                Toast.makeText(
                    this@MainActivity,
                    "Error Occurred",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}