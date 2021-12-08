package com.example.retrofitapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product : ProductEntity)

    @Query("SELECT * FROM products")
    fun getProducts() : LiveData<List<ProductEntity>>
}