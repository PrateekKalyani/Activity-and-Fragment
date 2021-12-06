package com.example.retrofitapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitapplication.network.RestClient
import com.example.retrofitapplication.network.RestClient.getApiService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ProductRepository() {

    val productList : MutableLiveData<List<ProductModel>> = MutableLiveData()

    init{
        RestClient.getApiService().getData().enqueue(object :
            retrofit2.Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                productList.value = response.body()
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}