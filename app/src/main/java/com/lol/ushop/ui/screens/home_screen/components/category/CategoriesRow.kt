package com.lol.shopforme.ui.screens.home_screen.components.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lol.shopforme.data.model.Categories

@Composable
fun CategoriesRow(modifier: Modifier = Modifier) {
  val categoriesDate =
      listOf(
          Categories(
              itemName = "Electronics",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/4361/4361756.png",
              isSelected = true,
          ),
          Categories(
              itemName = "Clothing",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/107/107499.png",
          ),
          Categories(
              itemName = "Books",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/29/29302.png",
          ),
          Categories(
              itemName = "Home Goods",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/18302/18302505.png",
          ),
          Categories(
              itemName = "Sports",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/4163/4163761.png",
          ),
      )
  LazyRow(modifier = modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
    items(categoriesDate) { category ->
      CategoryCard(
          itemName = category.itemName,
          icon = category.iconUrl,
          isSelected = category.isSelected,
      ) {}
    }
  }
}

@Preview
@Composable
private fun Aaaaaaaa() {
  CategoriesRow()
}


