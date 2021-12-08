package com.example.retrofitapplication.data

import androidx.lifecycle.LiveData
import com.example.retrofitapplication.Room.ProductDao
import com.example.retrofitapplication.Room.ProductEntity
import javax.inject.Inject

interface ProductCacheDataSource {

    fun getProduct() : LiveData<List<ProductEntity>>

    fun saveProducts(productList : List<ProductEntity>)
}

class ProductCacheDataSourceImpl
@Inject
constructor(
    private val productDao: ProductDao
    ): ProductCacheDataSource {

    override fun getProduct(): LiveData<List<ProductEntity>> {
        val productList = productDao.getProducts()
        return productList
    }

    override fun saveProducts(productList: List<ProductEntity>) {

        for (product in productList) {
            productDao.insert(product = product)
        }
    }

}