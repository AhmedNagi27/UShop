package com.lol.ushop.ui.screens.home_screen.components.feature_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun FeaturedProductCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    discount: String,
    title: String,
    imageUrl: String,
    price: String,
    rating: String,
) {
  Card(
      modifier = modifier.width(280.dp),
      shape = RoundedCornerShape(20.dp),
      elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
      onClick = onClick,
  ) {
    Box {
      if (discount.toInt() > 0) {
          DiscountBadge(
              discount = discount,
              modifier = Modifier.align(Alignment.TopEnd).padding(8.dp).zIndex(2f),
          )
      }
      Column(
          modifier = Modifier.align(Alignment.Center).padding(16.dp).zIndex(1f),
      ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = title,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth().height(140.dp),
        )
        Text(
            text = title,
            modifier = Modifier.padding(top = 6.dp),
            maxLines = 1,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 6.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
              text = "$price $",
              maxLines = 1,
              color = Color.Black,
              fontSize = 16.sp,
              style = MaterialTheme.typography.titleMedium,
          )
          Row(
              modifier = Modifier.padding(8.dp).zIndex(2f),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(4.dp),
          ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rating Star",
                tint = Color(0xFFF1B80B),
            )
            Text(
                text = rating,
                modifier = Modifier.padding(start = 4.dp),
                fontSize = 14.sp,
                color = Color.Black,
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun FeaturedProductCardPreview() {
  FeaturedProductCard(
      onClick = {},
      discount = "10",
      title = "Awesome Product",
      imageUrl = "https://example.com/image.jpg",
      price = "99.99",
      rating = "4.5",
  )
}
