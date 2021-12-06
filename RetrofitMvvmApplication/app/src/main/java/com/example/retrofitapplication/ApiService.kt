package com.example.retrofitapplication

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("products/")
    fun getData() : Call<List<ProductModel>>
}