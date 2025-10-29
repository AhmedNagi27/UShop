package com.lol.ushop.ui.screens.product_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lol.shopforme.data.model.Products

@SuppressLint("DefaultLocale")
@Composable
fun ProductDetailsScrren(
    modifier: Modifier = Modifier,
    product: Products,
    onBackArrowClick: () -> Unit,
    onWishlistClick: () -> Unit,
    onCartClick: () -> Unit,
) {
  Column(
      modifier = modifier.systemBarsPadding(),
      horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
      IconButton(
          onClick = onBackArrowClick,
          modifier = Modifier.align(Alignment.CenterVertically),
      ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
        )
      }
      Spacer(Modifier.width(16.dp))
      Text(text = "Details", style = MaterialTheme.typography.titleLarge)
    }
    HorizontalDivider()
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
      Text(
          text = product.name,
          style = MaterialTheme.typography.titleLarge,
          maxLines = 3,
      )
      Spacer(modifier = Modifier.height(8.dp))
      AsyncImage(
          model = product.imageUrl,
          contentDescription = "Product Image",
          modifier = Modifier.fillMaxWidth().height(300.dp),
      )
      Text(
          text = "$${String.format("%0.2f", product.price.toString())}",
          style = MaterialTheme.typography.titleLarge,
          maxLines = 1,
      )
    }
  }
}

@Preview
@Composable
fun ProductDetailsScrrenPreview() {
  ProductDetailsScrren(
      product =
          Products(
              id = "1",
              name = "Phone",
              price = 399.0,
              rating = 4.5,
              imageUrl = "https://cdn-icons-png.flaticon.com/128/2482/2482945.png",
              categoryId = "1",
          ),
      onBackArrowClick = {},
      onWishlistClick = {},
      onCartClick = {},
  )
}
