package com.lol.ushop.ui.screens.home_screen.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCategoryClick: () -> Unit,
    onHomeClick: () -> Unit,
    onWishlistClick: () -> Unit,
) {
  val items =
      listOf(
          BottomNavItem(title = "Home", icon = Icons.Default.Home, route = "Home"),
          BottomNavItem(title = "Categories", icon = Icons.Default.Search, route = "Categories"),
          BottomNavItem(
              title = "Wishlist",
              icon = Icons.Default.Favorite,
              route = "Wishlist",
              badgeCount = 10,
          ),
          BottomNavItem(
              title = "Cart",
              icon = Icons.Default.ShoppingCart,
              route = "Cart",
              badgeCount = 5,
          ),
          BottomNavItem(title = "Profile", icon = Icons.Default.Person, route = "Profile"),
      )
  var currentRoute by remember { mutableStateOf("Home") }
  NavigationBar(modifier = modifier, containerColor = Color.White, tonalElevation = 5.dp) {
    items.forEach { item ->
      NavigationBarItem(
          icon = {
            if (item.badgeCount != null && item.badgeCount > 0) {
              BadgedBox(badge = { Badge { Text(text = item.badgeCount.toString()) } }) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    modifier = Modifier.size(24.dp),
                )
              }
            } else
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    modifier = Modifier.size(24.dp),
                )
          },
          label = { Text(text = item.title) },
          selected = currentRoute == item.route,
          onClick = {
            currentRoute = item.route
            when (item.route) {
              "Home" -> onHomeClick()
              "Categories" -> onCategoryClick()
              "Wishlist" -> onWishlistClick()
              "Cart" -> onCartClick()
              "Profile" -> onProfileClick()
            }
          },
      )
    }
  }
}

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val badgeCount: Int? = null,
)
