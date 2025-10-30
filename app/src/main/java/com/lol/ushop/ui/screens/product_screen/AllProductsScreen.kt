package com.lol.ushop.ui.screens.product_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lol.shopforme.data.model.Products

@Composable
fun AllProductsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    omItemClick: () -> Unit,
) {
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
              imageUrl =
                  "https://www.computerscience.gcse.guru/wp-content/uploads/2016/02/Mouse.jpg",
              categoryId = "3",
          ),
          Products(
              id = "4",
              name = "Keyboard",
              price = 25.9,
              rating = 4.5,
              imageUrl =
                  "https://hardwarecomponentscomp1220uwi.weebly.com/uploads/1/5/3/6/15364906/8625897_orig.jpeg",
              categoryId = "3",
          ),
          Products(
              id = "4",
              name = "HeadPhones",
              price = 20.0,
              rating = 4.5,
              imageUrl =
                  "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcTCkxLhqil_Ez4-czIl_cJY7FASNaz4iqdsuTQVsQdxDnlBruVeOsGm7yrqaLsOQdWYxSYhIH0yck8Eqiu-yFmUvtLsxEG-tKZ7tdlsyITYYbrQxfc-d031PqGl1no1rbdvdwqSKQ&usqp=CAc",
              categoryId = "3",
          ),
          Products(
              id = "6",
              name = "Screen",
              price = 999.9,
              rating = 4.5,
              imageUrl =
                  "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcSjZxZXg0aUevzRceX9WJUN5pt3CszLmT_qR1is4TkGG_QKy4gEjHos0pGVFvAkLLvW45GcmMZ313BbZlWYaUY2BPSPIzCjs8qJXF1wDzshaaHUUClaDxmKZkUSTBIFlj1MpHOsIp1xEw&usqp=CAc",
              categoryId = "3",
          ),
      )
  Column(modifier = Modifier.systemBarsPadding()) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
        )
      }
      Spacer(modifier = Modifier.width(8.dp))
      Text(
          text = "Featured Products",
          style = MaterialTheme.typography.titleLarge,
          modifier = Modifier.padding(16.dp),
      )
    }
    HorizontalDivider()
    LazyColumn(
        modifier = modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      items(productList) { item -> ProductItemCard(product = item, onCartClick = {}, onClick = {}) }
    }
  }
}
