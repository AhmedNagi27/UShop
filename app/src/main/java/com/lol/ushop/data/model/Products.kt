package com.lol.shopforme.data.model

data class Products(
    val id: String = "",
    val name: String="",
    val price: Double=0.0,
    val rating: Double=0.0,
    val imageUrl: String="",
    val categoryId: String="",
)
