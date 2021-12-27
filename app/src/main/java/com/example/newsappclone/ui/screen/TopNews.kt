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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.ui.model.MockData
import com.example.newsappclone.ui.model.MockData.getTimeAgo
import com.example.newsappclone.ui.model.NewsData
import com.example.newsappclone.ui.model.TopNewsArticle
import com.example.newsappclone.R
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun TopNews(navController: NavController, articles: List<TopNewsArticle>) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Top news", fontWeight = FontWeight.SemiBold)

        LazyColumn {
            this.items(articles.size) { index ->
                TopNewsItem(article = articles[index],
                    onNewsClick = { navController.navigate("Detail/$index") }
                )
            }
        }

    }//Column

}

@Composable
fun TopNewsItem(
    article: TopNewsArticle,
    onNewsClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .height(200.dp)
            .padding(8.dp)
            .clickable {
                onNewsClick()

            }
    )
    {

        CoilImage(
            imageModel = article.urlToImage,
            contentScale = ContentScale.Crop,
            error = ImageBitmap.imageResource(id = R.drawable.breaking_news_us),
            placeHolder = ImageBitmap.imageResource(id = R.drawable.breaking_news_us)
        )

        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = MockData.stringToDate(article.publishedAt!!).getTimeAgo(),
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(80.dp))

            Text(text = article.title!!, color = Color.White, fontWeight = FontWeight.SemiBold)


        }//COLUMN


    }//BOX

}

@Preview(showBackground = true)
@Composable
fun TopNewsPreview() {

    //TopNews(rememberNavController())
    TopNewsItem(
        TopNewsArticle(

            author = "Tiago Romão",
            title = "Natal",
            description = "The suspected ...",
            publishedAt = "12/23/2021"

        )
    )
}