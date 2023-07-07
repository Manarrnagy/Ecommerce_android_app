package com.example.ecommerce_android_app.ui.theme.adapters

import android.graphics.Paint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ecommerce_android_app.R
import com.example.ecommerce_android_app.databinding.ActivityHomeBinding
import com.example.ecommerce_android_app.databinding.ProductItemBinding
import com.example.ecommerce_android_app.model.ProductItem

class ProductsAdapter(var products : List<ProductItem>) : Adapter<ProductsAdapter.ProductsViewHolder>() {

    class ProductsViewHolder(val binding : ProductItemBinding): ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = DataBindingUtil.inflate<ProductItemBinding>( LayoutInflater.from(parent.context),R.layout.product_item, parent,false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products.get(position)
        holder.binding.productDescription.text = product?.description
        holder.binding.productTitle.text = product?.title
        holder.binding.productRating.text = product?.rating.toString()
        holder.binding.productPrice.text = product?.price.toString()
        holder.binding.productPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.binding.productDiscount.text = ((100 - product!!.discountPercentage.toString().toDouble( ))/100*product?.price.toString().toDouble()).toInt().toString()
        Glide.with(holder.binding.thumbnail).load(product?.thumbnail).into(holder.binding.thumbnail)
    }

    fun changeData(newList : List<ProductItem>){
        products = newList
        notifyDataSetChanged()
    }

}