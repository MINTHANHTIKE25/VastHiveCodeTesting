package com.minthanhtike.vasthivecodetest.discover

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.minthanhtike.vasthivecodetest.R
import com.minthanhtike.vasthivecodetest.home.RowItems
import com.minthanhtike.vasthivecodetest.home.trendingData
import com.minthanhtike.vasthivecodetest.ui.theme.VastHiveCodeTestTheme

val exploreByTopics = listOf(
    DiscoverData.ExploreTopics(
        imageLink = "https://cdna.artstation.com/p/assets/images/images/041/627/208/4k/jon-yousef-889b95ce-8f68-4853-ade0-99f8ded15618.jpg?1632238423",
        caption = "Nature"
    ),
    DiscoverData.ExploreTopics(
        imageLink = "https://cdn.awesomepatternstudio.com/?source=aps/media/uploads/2023/07/12/227.jpg&",
        caption = "Health"
    ),
    DiscoverData.ExploreTopics(
        imageLink = "https://images.pexels.com/photos/302769/pexels-photo-302769.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        caption = "Travel"
    )
)

val exploreByWriters = listOf(
    DiscoverData.ExploreByWriters(
        imageLink = "https://cdn-images-1.medium.com/v2/resize:fill:1600:480/gravity:fp:0.5:0.4/0*MoyjIAKuFvoLzPh1",
        caption = "Howard"
    ),
    DiscoverData.ExploreByWriters(
        imageLink = "https://homeboundtarot.com/cdn/shop/articles/hans-isaacson-Mqx2-kbCVE8-unsplash_1_1100x.jpg?v=1690835065",
        caption = "Henry"
    ),
    DiscoverData.ExploreByWriters(
        imageLink = "https://gentscafe.co/wp-content/uploads/2023/03/the-power-of-journaling-1024x1024.jpeg",
        caption = "Travis"
    )
)

@Composable
fun DiscoverScreenDesign(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    ConstraintLayout(modifier = modifier.verticalScroll(state = rememberScrollState())) {
        val (searchFilterLayout, popularTxt, popularLzRow, byTopicsTxt, byTopicsLzRow,
            byWriterTxt, byWriterLzRow) = createRefs()
        val constraintModifier = Modifier
        Row(
            modifier = constraintModifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .constrainAs(searchFilterLayout) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val containerColor = MaterialTheme.colorScheme.onSecondary
            //region Search
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text(text = "Search for article") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    disabledContainerColor = containerColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(14.dp),
                trailingIcon = {},
                modifier = constraintModifier
                    .weight(0.6f)
                    .fillMaxHeight(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { /* ToDo */ })
            )

            Surface(
                onClick = { /*TODO*/ },
                modifier = constraintModifier
                    .width(35.dp)
                    .height(45.dp),
                color = Color.Transparent,
                border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "",
                    modifier = constraintModifier
                        .size(25.dp)
                        .padding(5.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            //endregion
        }


        //region Most Popular Article
        Text(
            text = "Most Popular Articles",
            modifier = constraintModifier
                .wrapContentSize()
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .constrainAs(popularTxt) {
                    top.linkTo(searchFilterLayout.bottom)
                    start.linkTo(parent.start)
                },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        var selectingMostPopular by remember{ mutableStateOf("") }
        LazyRow(
            modifier = constraintModifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(210.dp)
                .constrainAs(popularLzRow) {
                    top.linkTo(popularTxt.bottom)
                    start.linkTo(parent.start)
                },
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(trendingData) { item ->
                RowItems(
                    imageLink = item.img,
                    titles = item.title,
                    profileImg = item.profileImg,
                    name = item.profileName,
                    date = item.date,
                    selecting = item.profileName==selectingMostPopular
                ){
                    selectingMostPopular=it
                }
            }
        }
        //endregion

        //region Explore by topics
        Text(
            text = "Explore by Topics",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = constraintModifier
                .wrapContentSize()
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .constrainAs(byTopicsTxt) {
                    top.linkTo(popularLzRow.bottom)
                    start.linkTo(parent.start)
                }
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = constraintModifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(150.dp)
                .constrainAs(byTopicsLzRow) {
                    top.linkTo(byTopicsTxt.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(byWriterTxt.top)
                }
        ) {
            items(exploreByTopics) { item ->
                ExploreByTopicsItem(exploreTopics = item)
            }
        }
        //endregion

        //region Explore by writers
        Text(
            text = "Explore by writers",
            modifier = constraintModifier
                .wrapContentSize()
                .padding(horizontal = 15.dp, vertical = 10.dp)
                .constrainAs(byWriterTxt) {
                    top.linkTo(byTopicsLzRow.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(byWriterLzRow.top)
                },
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = constraintModifier
                .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(150.dp)
                .constrainAs(byWriterLzRow) {
                    top.linkTo(byWriterTxt.bottom)
                    start.linkTo(parent.start)
                }
        ) {
            items(exploreByWriters) { item ->
                ExploreByWriterItem(exploreByWriters = item)
            }
        }
        //endregion

    }
}


@Composable
fun ExploreByTopicsItem(
    exploreTopics: DiscoverData.ExploreTopics,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(220.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            model = exploreTopics.imageLink, contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Surface(
            color = Color.Black.copy(alpha = 0.4f),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Text(
                text = exploreTopics.caption,
                color = MaterialTheme.colorScheme.background,
                modifier = modifier.padding(start = 12.dp, bottom = 12.dp)
            )
        }
    }
}

@Composable
fun ExploreByWriterItem(
    exploreByWriters: DiscoverData.ExploreByWriters,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(220.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            model = exploreByWriters.imageLink, contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Surface(
            color = Color.Black.copy(alpha = 0.4f),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Text(
                text = exploreByWriters.caption,
                color = MaterialTheme.colorScheme.background,
                modifier = modifier.padding(start = 12.dp, bottom = 12.dp)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevDiscover() {
    VastHiveCodeTestTheme {
        DiscoverScreenDesign()
    }
}