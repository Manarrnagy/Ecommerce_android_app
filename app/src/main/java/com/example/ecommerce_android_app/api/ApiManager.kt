package com.example.ecommerce_android_app.api

import com.example.ecommerce_android_app.model.WebServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        private var retrofit: Retrofit? = null
        private fun getInstance(): Retrofit {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://dummyjson.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getApis(): WebServices {
            return getInstance().create(WebServices::class.java)
        }
    }
}