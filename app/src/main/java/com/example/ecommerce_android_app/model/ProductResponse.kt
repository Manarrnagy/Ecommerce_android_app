package com.example.ecommerce_android_app.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("products")
	val products: List<ProductItem?>? = null
)

data class ProductItem(

	@field:SerializedName("discountPercentage")
	var discountPercentage: Any? = null,

	@field:SerializedName("thumbnail")
	var thumbnail: String? = null,

	@field:SerializedName("images")
	var images: List<String?>? = null,

	@field:SerializedName("price")
	var price: Int? = null,

	@field:SerializedName("rating")
	var rating: Any? = null,

	@field:SerializedName("description")
	var description: String? = null,

	@field:SerializedName("id")
	var id: Int? = null,

	@field:SerializedName("title")
	var title: String? = null,

	@field:SerializedName("stock")
	var stock: Int? = null,

	@field:SerializedName("category")
	var category: String? = null,

	@field:SerializedName("brand")
	var brand: String? = null
)
