package com.example.ecommerce_android_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_android_app.api.ApiManager
import com.example.ecommerce_android_app.model.ProductItem
import com.example.ecommerce_android_app.model.ProductsResponse
import com.example.ecommerce_android_app.ui.theme.adapters.ProductsAdapter
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var newProductItem: ProductItem
    var discount : Double = 0.0
    var adapter : ProductsAdapter = ProductsAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        getProducts(this)
    }

    fun getProducts(context: Context){
        ApiManager.getApis().getProducts().enqueue(object : Callback<ProductsResponse> {
                override fun onResponse(
                    call: Call<ProductsResponse>,
                    response: Response<ProductsResponse>
                ) {
                    progressBar.isVisible = false
                    Log.e("ON RESPONSE ##","${response.body()}")
                    adapter.changeData(response.body()?.products as List<ProductItem>)

                }

                override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
                    progressBar.isVisible = false
                    Log.e("ON FALIURE ##","$t")
                    Toast.makeText(context,"Something went wrong!", Toast.LENGTH_LONG).show()
                }
            })
    }

//    fun showProducts(products: List<ProductItem>){
//        products.forEach {
//
//            newProductItem.thumbnail = it?.thumbnail
//            newProductItem.id = (it.id?: "") as Int?
//            newProductItem.title = it.title?: ""
//            newProductItem.description = it.description?: ""
//            newProductItem.rating = "Review "+it.rating?: ""
//            newProductItem.price = (it.price?: "") as Int?
//            newProductItem.discountPercentage= newProductItem.discountPercentage
//
//        }
//    }

    fun initViews(){
        progressBar = findViewById(R.id.progress_bar)
        recyclerView =findViewById(R.id.products_RV)
        recyclerView.adapter = adapter

    }

}