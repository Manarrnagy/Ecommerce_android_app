package com.example.ecommerce_android_app.api

import com.example.ecommerce_android_app.model.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
    @GET("/products")
    fun getProducts(): Call<ProductsResponse>
}