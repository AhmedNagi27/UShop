package com.lol.ushop.ui.screens.cart_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckOutSection(modifier: Modifier = Modifier, price: String, onCheckOut: () -> Unit) {
  Column(modifier = modifier.height(100.dp).padding(top = 2.dp)) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Text(text = "Total:", style = MaterialTheme.typography.bodyLarge)
      Text("$${price}", style = MaterialTheme.typography.bodyLarge)
    }
    Button(
        onClick = onCheckOut,
        modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally),
    ) {
      Text("CheckOut")
    }
  }
}

@Preview
@Composable
fun CheckOutSectionPreview() {
  CheckOutSection(
      price = "100.0",
      onCheckOut = {},
  )
}
