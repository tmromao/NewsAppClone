package com.example.newsappclone.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.ui.model.NewsData

@Composable
fun DetailScreen(navController: NavController, newsData: NewsData) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Detail Screen of Top news", fontWeight = FontWeight.SemiBold)

        Button(onClick = {

           // navController.navigate("TopNews")
            navController.popBackStack()

        }) {
            Text(text = "Go to Top News Screen + ${newsData.author}")
        }//Button

    }//Co

}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {

    DetailScreen(rememberNavController(),
    NewsData(2,
    author = "Tiago Romao",
    title = "Natal",
    description = "Bla bla bla",
    publishedAt = "2021-12-23"))
}