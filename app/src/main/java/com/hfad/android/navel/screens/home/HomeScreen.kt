package com.hfad.android.navel.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.R
import com.hfad.android.navel.models.DestCardModel
import com.hfad.android.navel.screens.components.DisplayRecommendationCard
import com.hfad.android.navel.screens.components.RatingCard
import com.hfad.android.navel.ui.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.primaryBackground)
            .padding(top = 30.dp, start = 30.dp),
    ) {
        Row(modifier = modifier
            .height(40.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = modifier) {


                Icon(modifier = modifier
                    .background(AppTheme.colors.hintTextColor)
                    .height(40.dp)
                    .width(40.dp), imageVector = Icons.Default.Person, contentDescription = null)
                Column(modifier = modifier.padding(start = 52.dp)) {
                    Text(text = "Welcome",
                        color = AppTheme.colors.primaryTintColor,
                        fontSize = 12.sp,
                        modifier = modifier)

                    Text(text = "Ketty",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = modifier,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp)
                }
            }
            Button(colors = ButtonDefaults.buttonColors(AppTheme.colors.primaryBackground),
                modifier = modifier
                    .padding(end = 24.dp)
                    .align(CenterVertically),
                onClick = { /*TODO*/ }) {
                Icon(painterResource(id = R.drawable.menu_icon),
                    contentDescription = null,
                    modifier = modifier.size(20.dp))
            }

        }

        Row(modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Recommendation",
                color = AppTheme.colors.headerTextColor,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = modifier)

            Button(colors = ButtonDefaults.buttonColors(AppTheme.colors.primaryBackground),
                modifier = modifier
                    .padding(end = 24.dp)
                    .align(CenterVertically),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = modifier.size(20.dp))
            }

        }

        Row(modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(AppTheme.colors.hintTextColor)) { }

        val destination = listOf(
            DestCardModel.BorobudurTemple,
            DestCardModel.KutaBeach,
            DestCardModel.ZionNationalPark,
            DestCardModel.KomodoIsland,
        )

        Row(modifier = Modifier) {


            LazyRow {
                stickyHeader {
                    Column(modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxHeight()
                        .width(22.dp)
                    ) {
                        Text(text = "Destination",
                            modifier = Modifier
                                .rotate(-90f))

                    }
                }

                itemsIndexed(destination) { _, dest ->
                    DisplayRecommendationCard(dest)

                }
            }
        }


    }
}


data class DrawableStringPair(val drawable: Int, val name: Int = 0)

@Preview
@Composable
fun HomeScreenPreview() {
    RatingCard(rating = 1.2)
}

@Preview
@Composable
fun DisplayRecCardPreview() {
    //DisplayRecommendationCard(drawable = R.drawable.borobudur_temple)
}