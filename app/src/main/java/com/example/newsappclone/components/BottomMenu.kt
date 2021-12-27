package com.example.newsappclone.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.newsappclone.R
import com.example.newsappclone.ui.BottomMenuScreen

@Composable
fun BottomMenu(navController: NavController) {

    val menuItems = listOf(BottomMenuScreen.TopNews, BottomMenuScreen.Categories, BottomMenuScreen.Sources)

    BottomNavigation(contentColor = colorResource(id = R.color.white)) {

    }

}