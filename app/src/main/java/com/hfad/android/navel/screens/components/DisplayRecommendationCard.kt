package com.hfad.android.navel.screens.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.R
import com.hfad.android.navel.models.DestCardModel
import com.hfad.android.navel.ui.theme.AppTheme


@Composable
fun DisplayRecommendationCard(
    destCardModel: DestCardModel,
) {
    val destName = destCardModel.name
    val type = destCardModel.type
    val location = destCardModel.location
    val rating = destCardModel.rating
    val addedToBookmark = destCardModel.addedToBookmark
    val imageUri = destCardModel.imageUri

    var bookmarkState by remember { mutableStateOf(addedToBookmark) }

    Box(modifier = Modifier
        .padding(start = 38.dp, top = 16.dp, bottom = 100.dp)
        .background(AppTheme.colors.accentColor)
        .fillMaxSize()) {

        Card(modifier = Modifier
            .width(width = 285.dp)
            .fillMaxHeight()
            .background(AppTheme.colors.primaryBackground),
            shape = RoundedCornerShape(38.dp)

        ) {
            Image(modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.primaryBackground),
                painter = painterResource(id = imageUri),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

        }

        RatingCard(modifier = Modifier.align(Alignment.TopStart), rating = rating)

        Column(modifier = Modifier
            .align(Alignment.BottomStart)
            .padding(bottom = 98.dp, start = 25.dp, end = 81.dp)
        ) {
            Text(
                modifier = Modifier,
                text = destName,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Normal,
                color = AppTheme.colors.primaryBackground
            )
            Text(
                modifier = Modifier,
                text = type,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Normal,
                color = AppTheme.colors.primaryBackground
            )
            Location(
                modifier = Modifier.padding(top = 4.dp),
                locationModel = location)
        }


        if (bookmarkState) {
            BookmarkButton(modifier = Modifier.align(Alignment.TopEnd),
                icon = R.drawable.bookmark_inactive){}
            BookmarkButton(modifier = Modifier.align(Alignment.TopEnd),
                icon = R.drawable.bookmark_active) {
                bookmarkState = !bookmarkState
            }
        } else {
            BookmarkButton(modifier = Modifier.align(Alignment.TopEnd),
                icon = R.drawable.bookmark_inactive) {
                bookmarkState = !bookmarkState
            }
        }



        Button(modifier = Modifier
            .align(Alignment.BottomEnd)
            .size(width = 90.dp, height = 56.dp)
            .padding(bottom = 25.dp, end = 25.dp),
            shape = RoundedCornerShape(CornerSize(32)),
            colors = ButtonDefaults.buttonColors(AppTheme.colors.actionButtonBackground),
            onClick = {
                Log.d("bookmark","button clicked")
            }
        ) {
            Icon(
                painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }
    }
}


@Composable
fun BookmarkButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    onClick: ()-> Unit
){
    IconButton(modifier = modifier
        .size(width = 58.dp, height = 86.dp)
        .padding(top = 28.dp, end = 24.dp),
        onClick = onClick,

    ){
        Image(
            modifier = modifier.fillMaxSize(),
            painter = painterResource(id = icon),
            contentDescription = null)
    }
}
