package com.example.ecommerce_android_app.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices {
    @GET("/products")
    fun getProducts(): Call<ProductsResponse>
}