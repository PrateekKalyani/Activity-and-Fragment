package com.example.retrofitapplication.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.retrofitapplication.ProductModel
import com.example.retrofitapplication.domain.ProductUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel
@Inject
constructor(
        private val productUseCase: ProductUserCase,
        private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    val productList: LiveData<List<ProductModel>> = productUseCase.getProduct()
}