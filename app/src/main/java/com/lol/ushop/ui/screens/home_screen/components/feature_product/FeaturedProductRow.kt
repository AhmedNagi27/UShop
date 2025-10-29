package com.lol.ushop.ui.screens.home_screen.components.feature_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lol.shopforme.data.model.Products

@Composable
fun FeaturedProductRow(modifier: Modifier = Modifier) {
  val productList =
      listOf(
          Products(
              id = "1",
              name = "Phone",
              price = 399.0,
              rating = 4.5,
              imageUrl = "https://cdn-icons-png.flaticon.com/128/2482/2482945.png",
              categoryId = "1",
          ),
          Products(
              id = "2",
              name = "Laptop",
              price = 999.9,
              rating = 4.5,
              imageUrl = "https://cdn-icons-png.flaticon.com/128/2888/2888704.png",
              categoryId = "2",
          ),
          Products(
              id = "3",
              name = "Mouse",
              price = 15.0,
              rating = 4.5,
              imageUrl = "https://www.computerscience.gcse.guru/wp-content/uploads/2016/02/Mouse.jpg",
              categoryId = "3",
          ),
          Products(
              id = "4",
              name = "Keyboard",
              price = 25.9,
              rating = 4.5,
              imageUrl = "https://hardwarecomponentscomp1220uwi.weebly.com/uploads/1/5/3/6/15364906/8625897_orig.jpeg",
              categoryId = "3",
          ),
          Products(
              id = "4",
              name = "HeadPhones",
              price = 20.0,
              rating = 4.5,
              imageUrl = "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcTCkxLhqil_Ez4-czIl_cJY7FASNaz4iqdsuTQVsQdxDnlBruVeOsGm7yrqaLsOQdWYxSYhIH0yck8Eqiu-yFmUvtLsxEG-tKZ7tdlsyITYYbrQxfc-d031PqGl1no1rbdvdwqSKQ&usqp=CAc",
              categoryId = "3",
          ),
          Products(
              id = "6",
              name = "Screen",
              price = 999.9,
              rating = 4.5,
              imageUrl = "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSjZxZXg0aUevzRceX9WJUN5pt3CszLmT_qR1is4TkGG_QKy4gEjHos0pGVFvAkLLvW45GcmMZ313BbZlWYaUY2BPSPIzCjs8qJXF1wDzshaaHUUClaDxmKZkUSTBIFlj1MpHOsIp1xEw&usqp=CAc",
              categoryId = "3",
          ),
      )
  LazyRow(modifier = modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
    items(productList) { item ->
        FeaturedProductCard(
            onClick = {},
            discount = "10",
            title = item.name,
            imageUrl = item.imageUrl,
            price = item.price.toString(),
            rating = item.rating.toString(),
        )
    }
  }
}
