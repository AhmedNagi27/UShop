package com.lol.ushop.ui.screens.profile_screen

data class UserProfile(
    val userId: String,
    val name: String,
    val email: String,
    val imageUrl: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSEVrOHAePo-kXtzd1lq2BcQ1DHempaBUQfRA&s"
)
