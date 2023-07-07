package com.example.ecommerce_android_app.ui.theme.screens.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_android_app.R
import com.example.ecommerce_android_app.databinding.ActivityHomeBinding
import com.example.ecommerce_android_app.model.ProductItem
import com.example.ecommerce_android_app.ui.theme.adapters.ProductsAdapter
import com.example.ecommerce_android_app.ui.theme.screens.home.home_view_model.ProductsViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var viewModel: ProductsViewModel
    lateinit var binding: ActivityHomeBinding
    var adapter : ProductsAdapter = ProductsAdapter(listOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initViews()
        viewModel.getProducts(this)
        observeViewModel(this)
    }



    fun initViews(){
        binding.productsRV.adapter = adapter
        viewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)

    }

    fun observeViewModel(context: Context){
        viewModel.tabsliveData.observe(this,object: Observer<List<ProductItem>>{
            override fun onChanged(products: List<ProductItem>?) {
                if (products != null) {
                    adapter.changeData(products)
                }
                else{
                    Toast.makeText(context,"Something went wrong!", Toast.LENGTH_LONG).show()
                }
            }

        })
        viewModel.progressVisibilityLiveData.observe(this){
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}