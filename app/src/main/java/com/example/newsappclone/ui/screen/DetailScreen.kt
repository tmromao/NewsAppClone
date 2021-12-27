package com.example.newsappclone.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.ui.model.NewsData
import com.example.newsappclone.R
import com.example.newsappclone.ui.model.MockData
import com.example.newsappclone.ui.model.MockData.getTimeAgo
import com.example.newsappclone.ui.model.TopNewsArticle
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun DetailScreen(article: TopNewsArticle, scrollState: ScrollState, navController: NavController) {


    Scaffold(topBar = {
        DetailTopAppBar(onBackPressed = { navController.popBackStack() })
    }) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Detail Screen of Top news", fontWeight = FontWeight.SemiBold)

            CoilImage(
                imageModel = article.urlToImage,
                contentScale = ContentScale.Crop,
                error = ImageBitmap.imageResource(R.drawable.breaking_news_us),
                placeHolder = ImageBitmap.imageResource(R.drawable.breaking_news_us)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                InfoWithIcon(Icons.Default.Edit, info = article.author ?: "Not Available")
                InfoWithIcon(
                    Icons.Default.DateRange,
                    info = MockData.stringToDate(article.publishedAt!!).getTimeAgo()
                )

            }//Row

            Text(text = article.title ?: "Not Available", fontWeight = FontWeight.Bold)
            Text(
                text = article.description ?: "Not Available",
                modifier = Modifier.padding(top = 16.dp)
            )
            /* Button(onClick = {

                // navController.navigate("TopNews")
                 navController.popBackStack()

             }) {
                 Text(text = "Go to Top News Screen + ${newsData.author}")
             }//Button*/

        }//Column

    }


}

@Composable
fun DetailTopAppBar(onBackPressed: () -> Unit = {}) {

    TopAppBar(title = {
        Text(text = "Detail Screen", fontWeight = FontWeight.SemiBold)
    },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")

            }
        })

}


@Composable
fun InfoWithIcon(icon: ImageVector, info: String) {

    Row() {
        Icon(
            icon,
            contentDescription = "Author",
            modifier = Modifier.padding(end = 8.dp),
            colorResource(id = R.color.purple_500)
        )

        Text(text = info)
    }


}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {

    DetailScreen(

        TopNewsArticle(
            author = "Namita Singht",
            title = "title 1",
            description = "description 1",
            publishedAt = "2021-11-04T04:42:40Z"
        ),
        rememberScrollState(),
        rememberNavController()
    )
}