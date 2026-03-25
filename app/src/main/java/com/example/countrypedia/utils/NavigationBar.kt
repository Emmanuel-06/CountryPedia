package com.example.countrypedia.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBar(
    val label: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)


val navigationBarItems = listOf(
    NavigationBar("Home", Icons.Filled.Home, Icons.Outlined.Home),
    NavigationBar("Favorites", Icons.Filled.Favorite, Icons.Outlined.FavoriteBorder)
)