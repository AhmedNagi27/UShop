package com.lol.ushop.ui.screens.product_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lol.shopforme.data.model.Products

@Composable
fun ProductItemCard(
    modifier: Modifier = Modifier,
    product: Products,
    onCartClick: () -> Unit,
    onClick: () -> Unit,
) {

  Card(
      modifier = modifier.fillMaxWidth().height(120.dp).padding(15.dp),
      shape = RoundedCornerShape(15.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
      onClick = onClick,
  ) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
      AsyncImage(
          model = product.imageUrl,
          contentDescription = product.name,
          modifier = Modifier.width(100.dp).clip(RoundedCornerShape(15.dp)),
          contentScale = ContentScale.Fit,
      )
      Column(
          modifier = Modifier.padding(start = 8.dp),
      ) {
        Text(
            text = product.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = "$${product.price}",
            maxLines = 1,
            style = MaterialTheme.typography.bodySmall,
        )
      }
      IconButton(
          onClick = onCartClick,
          modifier = Modifier.align(Alignment.CenterVertically).padding(8.dp),
      ) {
        Icon(
            imageVector = Icons.Outlined.ShoppingCart,
            contentDescription = "Remove Item",
            tint = MaterialTheme.colorScheme.inverseSurface,
        )
      }
    }
  }
}

@Preview
@Composable
fun ProductItemCardPreview() {
    val product = Products(id = "1", name = "Sample Product", price = 99.99, rating = 4.5, imageUrl = "", categoryId = "cat1")
    ProductItemCard(
        product = product,
        onCartClick = {},
        onClick = {}
    )
}
