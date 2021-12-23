package com.example.newsappclone.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.ui.model.MockData
import com.example.newsappclone.ui.model.NewsData

@Composable
fun TopNews(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Top news", fontWeight = FontWeight.SemiBold)

        LazyColumn {
            this.items(MockData.topNewsList) { newsData ->
                TopNewsItem(newsData = newsData, onNewsClick = {
                    navController.navigate("Detail/${newsData.id}")
                })

            }
        }

        /*      Button(onClick = {

                  navController.navigate("Detail")

              }) {
                  Text(text = "Go to detail screen")
              }//Button*/

    }//Column

}

@Composable
fun TopNewsItem(newsData: NewsData, onNewsClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp)
            .clickable {
                onNewsClick()

            }
    )
    {

        Image(
            painter = painterResource(id = newsData.image), contentDescription = "",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Text(text = newsData.publishedAt, color = Color.White, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(80.dp))

            Text(text = newsData.title, color = Color.White, fontWeight = FontWeight.SemiBold)


        }//COLUMN


    }//BOX

}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview() {

    //TopNews(rememberNavController())
    TopNewsItem(
        newsData = NewsData(
            2,
            author = "Tiago Romão",
            title = "Natal",
            description = "The suspected ...",
            publishedAt = "12/23/2021"
        )
    )
}