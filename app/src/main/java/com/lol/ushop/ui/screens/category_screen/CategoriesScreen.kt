package com.lol.shopforme.ui.screens.category_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.lol.shopforme.data.model.Categories

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    omItemClick: () -> Unit,
) {
  val categoriesDate =
      listOf(
          Categories(
              itemName = "Electronics",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/4361/4361756.png",
              isSelected = true,
          ),
          Categories(
              itemName = "Clothing",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/107/107499.png",
          ),
          Categories(
              itemName = "Books",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/29/29302.png",
          ),
          Categories(
              itemName = "Home Goods",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/18302/18302505.png",
          ),
          Categories(
              itemName = "Sports",
              iconUrl = "https://cdn-icons-png.flaticon.com/128/4163/4163761.png",
          ),
      )
  Column(modifier = Modifier.systemBarsPadding()) {
      Row(
          verticalAlignment = Alignment.CenterVertically
      ){
          IconButton(onClick = { navController.popBackStack() }){
              Icon(
                  imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                  contentDescription = "Back",
              )

          }
          Spacer(modifier = Modifier.width(8.dp))
          Text(
              text = "Categories",
              style = MaterialTheme.typography.titleLarge,
              modifier= Modifier.padding(16.dp),
          )
      }

    HorizontalDivider()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.padding(8.dp).systemBarsPadding(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      items(categoriesDate) { item ->
        Card(
            onClick = omItemClick,
            modifier = Modifier.padding(12.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        ) {
          Column(
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally,
          ) {
            AsyncImage(
                model = item.iconUrl,
                contentDescription = item.itemName,
                modifier = modifier.clip(CircleShape),
                contentScale = ContentScale.Fit,
            )
            Text(
                text = item.itemName,
                modifier = Modifier.padding(8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
            )
          }
        }
      }
    }
  }
}
