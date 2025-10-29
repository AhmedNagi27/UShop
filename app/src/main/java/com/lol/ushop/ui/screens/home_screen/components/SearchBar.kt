package com.lol.ushop.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
) {
  Box(
      modifier =
          modifier
              .height(50.dp)
              .clip(RoundedCornerShape(20.dp))
              .background(Color.LightGray.copy(alpha = 0.3f)),
      contentAlignment = Alignment.Center,
  ) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
      Icon(Icons.Default.Search, "Search Icon", tint = Color.Gray)
      Spacer(Modifier.width(8.dp))
      TextField(
          value = query,
          onValueChange = onQueryChange,
          singleLine = true,
          placeholder = { Text(text = "Search...", color = Color.Gray, fontSize = 16.sp) },
          modifier = Modifier.weight(1f),
          keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
          keyboardActions = KeyboardActions(onSearch = { onSearch() }),
          textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
          colors =
              TextFieldDefaults.colors(
                  focusedIndicatorColor = Color.Transparent,
                  unfocusedIndicatorColor = Color.Transparent,
                  disabledIndicatorColor = Color.Transparent,
                  errorIndicatorColor = Color.Transparent,
                  focusedContainerColor = Color.Transparent,
                  unfocusedContainerColor = Color.Transparent,
              ),
      )
    }
  }
}

@Preview
@Composable
fun SearchBarPreview() {
  var query by remember { mutableStateOf("") }
  SearchBar(query = query, onQueryChange = { query = it }, onSearch = {})
}