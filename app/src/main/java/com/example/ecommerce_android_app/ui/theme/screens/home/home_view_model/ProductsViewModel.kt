package com.example.ecommerce_android_app.ui.theme.screens.home.home_view_model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce_android_app.api.ApiManager
import com.example.ecommerce_android_app.model.ProductItem
import com.example.ecommerce_android_app.model.ProductsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel() {
    var tabsliveData = MutableLiveData<List<ProductItem>>()
    var progressVisibilityLiveData = MutableLiveData<Boolean>()
    fun getProducts(context: Context){
        progressVisibilityLiveData.value= true
        ApiManager.getApis().getProducts().enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(
                call: Call<ProductsResponse>,
                response: Response<ProductsResponse>
            ) {
                progressVisibilityLiveData.value= false
                Log.e("ON RESPONSE ##","${response.body()}")
                tabsliveData.value = response.body()?.products as List<ProductItem>

            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                progressVisibilityLiveData.value= false
                Log.e("ON FALIURE ##","$t")

            }
        })
    }
}