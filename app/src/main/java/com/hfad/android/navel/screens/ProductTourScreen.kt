package com.hfad.android.navel.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.hfad.android.navel.R
import com.hfad.android.navel.models.models
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.ui.theme.NavelTheme
import com.hfad.android.navel.utils.Screen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductTourScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    Box(modifier = modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(3)
        var currentPage by remember {
            mutableStateOf(pagerState.currentPage)
        }

        Image(painter = painterResource(models[currentPage].image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize())



        SignInButton(
            modifier = modifier.align(Alignment.BottomEnd),
            currentPage = currentPage,
            onButtonClick = { currentPage++ },
            navController = navController
        )
    }

}


@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    currentPage: Int,
    navController: NavController,
) {
    Box(
        modifier = modifier.padding(end = 24.dp, bottom = 42.dp)
    ) {

        Button(modifier = modifier
            .size(width = 114.dp, height = 46.dp),
            shape = RoundedCornerShape(CornerSize(24.dp)),
            colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
            onClick = onButtonClick
        ) {
            Icon(
                painterResource(id = R.drawable.arrow_right),
                contentDescription = null,
            )
        }

        if (currentPage == 2) {
            Button(modifier = modifier
                .size(width = 114.dp, height = 46.dp),
                shape = RoundedCornerShape(CornerSize(24.dp)),
                colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                onClick = { navController.navigate(route = Screen.Login.name) }
            ) {
                Text(text = stringResource(R.string.login),
                    modifier = modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }

}


@Preview
@Composable
fun HorizontalTabPreview() {

    NavelTheme {
        //ProductTourSlide()
    }
}



