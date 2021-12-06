package com.example.retrofitapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    val productList: MutableLiveData<List<ProductModel>> = ProductRepository().productList
}