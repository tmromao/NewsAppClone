package com.example.newsappclone.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.components.BottomMenu
import com.example.newsappclone.ui.model.MockData
import com.example.newsappclone.ui.screen.Categories
import com.example.newsappclone.ui.screen.DetailScreen
import com.example.newsappclone.ui.screen.Sources
import com.example.newsappclone.ui.screen.TopNews

@Composable
fun NewsApp() {

    val scrollState = rememberScrollState()
    val navController = rememberNavController()
    MainScreen(navController = navController, scrollState = scrollState)
}

@Composable
fun MainScreen(navController: NavHostController, scrollState: ScrollState) {

    Scaffold(bottomBar = {
        BottomMenu(navController)
    }) {
        Navigation(navController = navController, scrollState = scrollState)
    }

}

@Composable
fun Navigation(navController: NavHostController, scrollState: ScrollState) {

    NavHost(navController = navController, startDestination = "TopNews") {

        bottomNavigation(navController = navController)

        composable("TopNews") {

            TopNews(navController = navController)

        }
        composable(
            "Detail/{newsId}",
            arguments = listOf(navArgument("newsId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt("newsId")
            val newsData = MockData.getNews(id)
            DetailScreen(
                newsData = newsData,
                scrollState = scrollState,
                navController = navController
            )
        }

    }
}

fun NavGraphBuilder.bottomNavigation(navController: NavController) {

    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController = navController)
    }
    composable(BottomMenuScreen.Categories.route) {
        Categories()

    }
    composable(BottomMenuScreen.Sources.route) {
        Sources()
    }

}