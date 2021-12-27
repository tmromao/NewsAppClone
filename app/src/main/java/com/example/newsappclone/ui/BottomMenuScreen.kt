package com.example.newsappclone.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface BottomMenuScreen(val route: String, icon: ImageVector, val title:String){


    object TopNews:BottomMenuScreen("top news", icon = Icons.Outlined.Home, "Top News")

    object Categories:BottomMenuScreen("categories", icon = Icons.Outlined.Category, "Categories")

    object Sources:BottomMenuScreen("sources", icon = Icons.Outlined.Home, "Sources")



}