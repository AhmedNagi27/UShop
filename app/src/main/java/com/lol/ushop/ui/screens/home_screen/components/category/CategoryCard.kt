package com.lol.ushop.ui.screens.home_screen.components.category

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    itemName: String,
    icon: String,
    isSelected: Boolean = false,
    onItemClick: () -> Unit,
) {
  Card(
      modifier =
          Modifier.clickable(onClick = { onItemClick() }).then(modifier),
      shape = RoundedCornerShape(20.dp),
      colors =
          CardDefaults.cardColors(
              containerColor = if (isSelected) Color(0xFF19BF0A) else Color(0xffEEEEEE),
              contentColor = if (isSelected) Color.White else Color.Black,
          ),
      elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
      border =
          BorderStroke(
              width = if (isSelected) 0.dp else 1.dp,
              color = Color.LightGray.copy(0.3f),
          ),
  ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
      Icon(
          painter = rememberAsyncImagePainter(icon),
          contentDescription = itemName,
          modifier = Modifier.size(20.dp),
      )
      Text(
          text = itemName,
          modifier = Modifier.padding(8.dp),
          style = MaterialTheme.typography.bodyMedium,
      )
    }
  }
}

@Preview
@Composable
fun CategoryCardPreview() {
  CategoryCard(itemName = "Electronics", isSelected = true, onItemClick = {}, icon = "hack")
}
