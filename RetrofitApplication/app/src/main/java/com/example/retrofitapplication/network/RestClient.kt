package com.example.retrofitapplication.network

import com.example.retrofitapplication.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {

    private const val BASE_URL = "https://fakestoreapi.com/"
    private var apiService : ApiService? = null

    fun getApiService(): ApiService {

        if(apiService == null) {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService!!
    }
}