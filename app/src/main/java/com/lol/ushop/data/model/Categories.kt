package com.lol.shopforme.data.model

data class Categories(
    val id: Int = 0,
    val itemName: String,
    val iconUrl: String,
    val isSelected: Boolean = false,
)
