package com.example.ecommerce_android_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_android_app.api.ApiManager
import com.example.ecommerce_android_app.databinding.ActivityHomeBinding
import com.example.ecommerce_android_app.model.ProductItem
import com.example.ecommerce_android_app.model.ProductsResponse
import com.example.ecommerce_android_app.ui.theme.adapters.ProductsAdapter
import com.example.ecommerce_android_app.view_model.ProductsViewModel
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var viewModel: ProductsViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    //lateinit var binding: ActivityHomeBinding
    var adapter : ProductsAdapter = ProductsAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)
        initViews()
        viewModel.getProducts(this)
        //binding = ActivityHomeBinding.inflate(layoutInflater)

        //setContentView(binding.root)

        observeViewModel()
    }


//    fun getProducts(context: Context){
//        ApiManager.getApis().getProducts().enqueue(object : Callback<ProductsResponse> {
//                override fun onResponse(
//                    call: Call<ProductsResponse>,
//                    response: Response<ProductsResponse>
//                ) {
//                    progressBar.isVisible = false
//                    //binding.progressBar.isVisible = false
//                    Log.e("ON RESPONSE ##","${response.body()}")
//                    adapter.changeData(response.body()?.products as List<ProductItem>)
//
//                }
//
//                override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
//                    //binding.progressBar.isVisible = false
//                   progressBar.isVisible = false
//                    Log.e("ON FALIURE ##","$t")
//                    Toast.makeText(context,"Something went wrong!", Toast.LENGTH_LONG).show()
//                }
//            })
//    }


    fun initViews(){
        progressBar = findViewById(R.id.progress_bar)
        recyclerView =findViewById(R.id.products_RV)
       // binding.productsRV.adapter = adapter
        recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

    }

    fun observeViewModel(){
        viewModel.tabsliveData.observe(this,object: Observer<List<ProductItem>>{
            override fun onChanged(products: List<ProductItem>?) {
                if (products != null) {
                    adapter.changeData(products)
                }
            }

        })
        viewModel.progressVisibilityLiveData.observe(this){
            if (it) {
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        }
    }

}