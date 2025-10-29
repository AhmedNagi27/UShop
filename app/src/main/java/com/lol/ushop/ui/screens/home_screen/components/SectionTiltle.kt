package com.lol.shopforme.ui.screens.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(modifier: Modifier = Modifier, title: String, onActionClick: () -> Unit) {
  Row(
      modifier =
          Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 16.dp).then(modifier),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
        text = title,
        style =
            MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
    )
    Text(
        text = "See All",
        color = Color.Blue,
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier.clickable(onClick = { onActionClick() }),
    )
  }
}

@Preview
@Composable
fun SectionTitlePreview() {
  SectionTitle(title = "Section Title", onActionClick = {})
}
