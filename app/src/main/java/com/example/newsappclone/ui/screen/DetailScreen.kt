package com.example.newsappclone.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsappclone.ui.model.NewsData
import com.example.newsappclone.R

@Composable
fun DetailScreen(newsData: NewsData, scrollState: ScrollState) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Detail Screen of Top news", fontWeight = FontWeight.SemiBold)

        Image(painterResource(id = newsData.image), contentDescription = "")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            InfoWithIcon(Icons.Default.Edit, info = newsData.author)
            InfoWithIcon(Icons.Default.DateRange, info = newsData.publishedAt)

        }//Row

        Text(text = newsData.title, fontWeight = FontWeight.Bold)
        Text(text = newsData.description, modifier = Modifier.padding(top = 16.dp))
        /* Button(onClick = {

            // navController.navigate("TopNews")
             navController.popBackStack()

         }) {
             Text(text = "Go to Top News Screen + ${newsData.author}")
         }//Button*/

    }//Column

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
        NewsData(
            2,
            author = "Tiago Romao",
            title = "Natal",
            description = "Bla bla bla",
            publishedAt = "2021-12-23"
        ),
        rememberScrollState()
    )
}