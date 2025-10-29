package com.lol.shopforme.ui.screens.home_screen.components.feature_product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DiscountBadge(
    modifier: Modifier = Modifier,
    discount: String,
) {
  Box(
      modifier = modifier.clip(RoundedCornerShape(18.dp)).background(color = Color(0xffe91e63)),
  ) {
    Text(
        text = "$discount% OFF",
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    )
  }
}
