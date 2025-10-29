package com.lol.ushop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lol.ushop.ui.screens.cart_screen.CartScreen
import com.lol.ushop.ui.screens.category_screen.CategoriesScreen
import com.lol.ushop.ui.screens.home_screen.HomeScreen
import com.lol.ushop.ui.screens.profile_screen.ProfileScreen

@Composable
fun NavSystem(modifier: Modifier = Modifier) {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "Home", modifier = modifier) {
    composable("Home") {
      HomeScreen(
          navController = navController,
          onProfileClick = { navController.navigate("Profile") },
          onCartClick = { navController.navigate("Cart") },
          onCategoryClick = { navController.navigate("Categories") },
      )
    }
    composable("Cart") {
      CartScreen(
          navController = navController,
          onBackArrowClick = { navController.popBackStack() },
          onCheckOut = {},
      )
    }
    composable("Profile") {
      ProfileScreen(
          navController = navController,
          onSignOut = {},
          onBackArrowClick = { navController.popBackStack() },
      )
    }
      composable (route = "Categories"){
          CategoriesScreen(navController = navController, omItemClick = {})
      }
  }
}
