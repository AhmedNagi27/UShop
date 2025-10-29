package com.lol.ushop.ui.screens.profile_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onSignOut: () -> Unit,
    onBackArrowClick: () -> Unit,
) {
  val currentUser = UserProfile(userId = "1", name = "Ahmed Nagi", email = "ahmednagi@gmail.com")
  Column(
      modifier = modifier.systemBarsPadding(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
  ) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
      IconButton(
          onClick = onBackArrowClick,
          modifier = Modifier.align(Alignment.CenterVertically),
      ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
        )
      }
      Spacer(Modifier.width(16.dp))
      Text(text = "Profile", style = MaterialTheme.typography.titleLarge)
    }
    HorizontalDivider()
    Spacer(modifier = Modifier.height(16.dp))
    AsyncImage(
        model = currentUser.imageUrl,
        contentDescription = currentUser.name,
        modifier = Modifier.height(150.dp).clip(CircleShape),
        contentScale = ContentScale.Fit,
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = currentUser.name,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = currentUser.email,
        style = MaterialTheme.typography.bodyMedium,
    )
    Spacer(modifier = Modifier.height(16.dp))
    Button(
        onClick = onSignOut,
        modifier = Modifier.align(Alignment.CenterHorizontally),
    ) {
      Text(text = "Sign Out")
    }
  }
}
