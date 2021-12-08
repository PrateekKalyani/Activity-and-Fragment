package com.example.retrofitapplication.Models

import com.example.retrofitapplication.RatingModel

data class Product(
    val id : Int,
    val title : String,
    val price : Float,
    val description : String,
    val category : String,
    val image : String,
    val rating : RatingModel
)
