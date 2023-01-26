package com.hfad.android.navel.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.ui.screens.components.DisplayDestinationCard
import com.hfad.android.navel.ui.screens.components.HorizontalLine
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.ui.viewmodel.NavelViewModel

@Composable
fun BookmarkScreen(
    navelViewModel: NavelViewModel,
    modifier: Modifier = Modifier,
) {
    val state = navelViewModel.uiState.observeAsState(initial = listOf())
    //val destCardState by remember { mutableStateOf(state) }


    Surface(
        modifier = modifier.fillMaxSize(),
        color = AppTheme.colors.primaryBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 30.dp, top = 45.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your Bookmark",
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.headerTextColor,
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )

                IconButton(
                    modifier = Modifier.padding(end = 38.dp),
                    onClick = { /*TODO*/ }
                ) {

                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                }
            }
            HorizontalLine()

            if (state.value.isEmpty()) {
                BookmarkIsEmpty(modifier = modifier.padding(top = 258.dp))
            } else {

                LazyRow {

                    // val destination = navelViewModel.uiState.value
                    itemsIndexed(state.value) { _, dest ->
                        if (dest.addedToBookmark){
                            DisplayDestinationCard(
                                currentCardModel = dest,
                                navelViewModel = navelViewModel
                            )
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun BookmarkIsEmpty(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(end = 101.dp),
            text = "It's empty in here",
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.headerTextColor,
            fontSize = 40.sp
        )
        Text(
            modifier = Modifier.padding(end = 101.dp),
            text = "Try add some destination to your bookmark",
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.hintTextColor,
            fontSize = 12.sp
        )
    }
}