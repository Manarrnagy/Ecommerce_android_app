package com.example.ecommerce_android_app.ui.theme.adapters

import android.graphics.Paint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.ecommerce_android_app.R
import com.example.ecommerce_android_app.model.ProductItem

class ProductsAdapter(var products : List<ProductItem>) : Adapter<ProductsAdapter.ProductsViewHolder>() {
    class ProductsViewHolder(val item: View): ViewHolder(item) {
        val thumbnail : ImageView = item.findViewById(R.id.thumbnail)
        val title : TextView = item.findViewById(R.id.product_title)
        val description : TextView = item.findViewById(R.id.product_description)
        val price : TextView = item.findViewById(R.id.product_price)
        val discount : TextView = item.findViewById(R.id.product_discount)
        val rating : TextView = item.findViewById(R.id.product_rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent,false)
        return ProductsViewHolder(view)
    }

    override fun getItemCount(): Int {
       return products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products.get(position)
        holder.description.text = product?.description
        holder.title.text = product?.title
        holder.rating.text = product?.rating.toString()
        holder.price.text = product?.price.toString()
        holder.price.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.discount.text = ((100 - product!!.discountPercentage.toString().toDouble( ))/100*product?.price.toString().toDouble()).toInt().toString()
        Glide.with(holder.item).load(product?.thumbnail).into(holder.thumbnail)
    }

    fun changeData(newList : List<ProductItem>){
        products = newList
        notifyDataSetChanged()
    }

}