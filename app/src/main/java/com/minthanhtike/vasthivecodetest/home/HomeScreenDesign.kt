package com.minthanhtike.vasthivecodetest.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.minthanhtike.vasthivecodetest.R
import com.minthanhtike.vasthivecodetest.ui.theme.VastHiveCodeTestTheme


val trendingData = listOf(
    HomesData.Trending(
        title = "Ways to Increase your Reading Efficiently",
        profileImg = "https://images.pexels.com/photos/1239291/pexels-photo-1239291.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        profileName = "Bella",
        img = "https://static.wixstatic.com/media/505267_ab7226e41cf04ab4914ca588d02a17e4~mv2.jpg/v1/crop/x_56,y_0,w_188,h_184/fill/w_263,h_257,al_c,lg_1,q_80,enc_auto/CA101-00.jpg",
        date = "2 days ago"
    ),
    HomesData.Trending(
        title = "Ways to Increase your TeamWork Power",
        profileImg = "https://images.pexels.com/photos/712513/pexels-photo-712513.jpeg",
        profileName = "Isabelle",
        img = "https://miro.medium.com/v2/resize:fit:828/format:webp/1*9zYL0nGt24kOD5ghsy35ag.jpeg",
        date = "5 days ago"
    ),
    HomesData.Trending(
        title = "Ways to work under the pressure and working ",
        profileImg = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        profileName = "Louis Volkton",
        img = "https://prsay.prsa.org/wp-content/uploads/2021/08/stress-1024x614.jpeg",
        date = "7 days ago"
    )
)

@Composable
fun HomeScreenDesign(
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier.verticalScroll(state = rememberScrollState())) {
        val modifierOfConstraint = Modifier
        val (topCard, trendingText, trendLazyRow,
            recentTxt, recentLazyRow, popularTxt,
            popularLazyRow) = createRefs()

        //region Top card
        Card(
            modifier = modifierOfConstraint
                .fillMaxWidth()
                .height(190.dp)
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .constrainAs(topCard) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(trendingText.top)
                },
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Row(
                modifier = modifierOfConstraint
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Column(
                    modifier = modifierOfConstraint
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.7f),
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Text(
                        text = "Learn and become a great writer" +
                                ".Start your journey today with Us!",
                        color = MaterialTheme.colorScheme.background,
                        textAlign = TextAlign.Left,
                        modifier = modifierOfConstraint.padding(bottom = 5.dp),
                        fontSize = 14.sp
                    )
                    ElevatedButton(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        modifier = modifierOfConstraint.size(width = 120.dp, height = 35.dp)
                    ) {
                        Text(
                            text = "Know More",
                            fontSize = 12.sp,
                            overflow = TextOverflow.Visible,
                            textAlign = TextAlign.Start
                        )
                    }
                }
                Box(
                    modifier = modifierOfConstraint
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(0.3f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.modeltwo),
                        contentDescription = "hi",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
        //endregion

        //region Trending Article

        Text(
            text = "Trending Articles",
            modifier = modifierOfConstraint
                .padding(start = 16.dp)
                .constrainAs(trendingText) {
                    top.linkTo(topCard.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(trendLazyRow.top)
                },
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        var selectingTrend by remember { mutableStateOf("") }
        LazyRow(
            modifier = modifierOfConstraint
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 16.dp)
                .fillMaxWidth()
                .height(210.dp)
                .constrainAs(trendLazyRow) {
                    top.linkTo(trendingText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            state = rememberLazyListState()
        ) {
            items(trendingData) { item ->
                RowItems(
                    imageLink = item.img,
                    titles = item.title,
                    profileImg = item.profileImg,
                    name = item.profileName,
                    date = item.date,
                    selecting = item.profileName == selectingTrend
                ){
                    selectingTrend=it
                }
            }
        }
        Log.d("Selection", "RecentSelectList: $selectingTrend")
        //endregion

        //region Recent Articles
        Text(
            text = "Recent Articles",
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifierOfConstraint
                .padding(start = 16.dp)
                .constrainAs(recentTxt) {
                    top.linkTo(trendLazyRow.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(recentLazyRow.top)
                },
            fontWeight = FontWeight.Bold
        )

        var selectingRecent by remember { mutableStateOf("") }
        LazyRow(
            modifier = modifierOfConstraint
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 16.dp)
                .fillMaxWidth()
                .height(210.dp)
                .constrainAs(recentLazyRow) {
                    top.linkTo(recentTxt.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            state = rememberLazyListState()
        ) {
            items(trendingData) { item ->
                RowItems(
                    imageLink = item.img,
                    titles = item.title,
                    profileImg = item.profileImg,
                    name = item.profileName,
                    date = item.date,
                    selecting = selectingRecent==item.profileName
                ){
                    selectingRecent=it
                }
            }
        }
        Log.d("Selection", "RecentSelectList: $selectingRecent")
        //endregion

        //region Popular Article
        Text(
            text = "Popular Articles",
            style = MaterialTheme.typography.headlineMedium,
            modifier = modifierOfConstraint
                .padding(start = 16.dp)
                .constrainAs(popularTxt) {
                    top.linkTo(recentLazyRow.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(popularLazyRow.top)
                },
            fontWeight = FontWeight.Bold
        )

        var selectingPopular by remember { mutableStateOf("") }
        LazyRow(
            modifier = modifierOfConstraint
                .padding(start = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(210.dp)
                .constrainAs(popularLazyRow) {
                    top.linkTo(popularTxt.bottom)
                    start.linkTo(parent.start)
                },
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            state = rememberLazyListState()
        ) {
            itemsIndexed(trendingData) { index,item ->
                RowItems(
                    imageLink = item.img,
                    titles = item.title,
                    profileImg = item.profileImg,
                    name = item.profileName,
                    date = item.date,
                    selecting = item.profileName == selectingPopular
                ){
                    selectingPopular=it
                }
            }
        }
        //endregion

    }
}

@Composable
fun RowItems(
    selecting:Boolean,
    modifier: Modifier = Modifier,
    imageLink: String,
    titles: String,
    profileImg: String,
    name: String,
    date: String,
    onClick: (String) -> Unit
) {
    var savedBtn by remember { mutableStateOf(false) }
    ConstraintLayout(
        modifier = modifier
            .width(200.dp)
            .fillMaxHeight()
    ) {
        val (saveBtn, image, personDetail, time, title) = createRefs()
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(title.top)
                },
            shape = RoundedCornerShape(15.dp)
        ) {
            AsyncImage(
                model = imageLink,
                contentDescription = "",
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

        IconButton(
            onClick = {
                savedBtn = !savedBtn
                onClick(name)
            },
            modifier = modifier
                .size(30.dp)
                .padding(start = 3.dp, top = 8.dp)
                .constrainAs(saveBtn) {
                    top.linkTo(image.top)
                    start.linkTo(parent.start)
                }) {
            Icon(
                imageVector = if (selecting ) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                contentDescription = "save",
                tint = MaterialTheme.colorScheme.inversePrimary,
                modifier = modifier.fillMaxSize()
            )
        }

        Text(
            text = titles,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(title) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(personDetail.top)
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = modifier
                .padding(horizontal = 6.dp, vertical = 8.dp)
                .width(150.dp)
                .constrainAs(personDetail) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = profileImg,
                contentDescription = "",
                modifier = modifier
                    .clip(CircleShape)
                    .size(25.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.outline,
                modifier = modifier
                    .padding(start = 6.dp, end = 6.dp)
                    .width(100.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
        Text(
            text = date,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.outline,
            modifier = modifier
                .wrapContentWidth()
                .padding(top = 11.dp)
                .constrainAs(time) {
                    top.linkTo(title.bottom)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevHomeScnDesign() {
    VastHiveCodeTestTheme {
        HomeScreenDesign()
    }
}