package com.lol.ushop.ui.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lol.ushop.ui.screens.home_screen.components.BottomNavBar
import com.lol.ushop.ui.screens.home_screen.components.HomeTopAppBar
import com.lol.ushop.ui.screens.home_screen.components.SearchBar
import com.lol.ushop.ui.screens.home_screen.components.SectionTitle
import com.lol.ushop.ui.screens.home_screen.components.category.CategoriesRow
import com.lol.ushop.ui.screens.home_screen.components.feature_product.FeaturedProductRow

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onProfileClick: () -> Unit,
    onCartClick: () -> Unit,
    onCategoryClick: () -> Unit,
) {
  Scaffold(
      modifier = modifier,
      topBar = { HomeTopAppBar(onCartClick = onCartClick, onProfileClick = onProfileClick) },
      bottomBar = {
        BottomNavBar(
            onCartClick = { onCartClick() },
            onProfileClick = { onProfileClick() },
            onCategoryClick = { onCategoryClick() },
            onHomeClick = { navController.navigate("Home") },
            onWishlistClick = {},
        )
      },
  ) {
    Column(modifier = Modifier.fillMaxSize().padding(it)) {
      // Search Bar
      var SearchQuery by remember { mutableStateOf("") }
      val focusManager = LocalFocusManager.current
      SearchBar(
          query = SearchQuery,
          onQueryChange = { SearchQuery = it },
          onSearch = { focusManager.clearFocus() },
          modifier = Modifier.fillMaxWidth().padding(16.dp),
      )
      // Search Section
      // Categories Section
      SectionTitle(
          title = "Categories",
          modifier = Modifier.fillMaxWidth(),
          onActionClick = onCategoryClick,
      )
      CategoriesRow()
      // Featured Products Section
      Spacer(modifier = Modifier.height(16.dp))
      SectionTitle(title = "Featured Products", modifier = Modifier.fillMaxWidth()) {}
      FeaturedProductRow(navController = navController)
    }
  }
}
