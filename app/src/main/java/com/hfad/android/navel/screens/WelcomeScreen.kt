package com.hfad.android.navel.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hfad.android.navel.R
import com.hfad.android.navel.screens.login.DataStorePref
import com.hfad.android.navel.screens.login.screens.EMAIL_KEY
import com.hfad.android.navel.screens.login.Login
import com.hfad.android.navel.screens.login.screens.PASSWORD_KEY
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.ui.theme.NavelTheme
import com.hfad.android.navel.utils.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(navController: NavController) = Box(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = AppTheme.colors.borderColor)
) {
    val mContext = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scale = remember {
        Animatable(0.0f)
    }

    LaunchedEffect(key1 = true) {
        launch {
            email = DataStorePref(mContext).read(EMAIL_KEY) ?: ""
            password = DataStorePref(mContext).read(PASSWORD_KEY) ?: ""

        }
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(800, easing = {
                OvershootInterpolator(4f).getInterpolation(it)
            })
        )
        if (email != "" && password != "") {
            Login(mContext).login(email, password)
        } else {
            navController.navigate(Screen.ProductTour.name) {
                popUpTo(Screen.Welcome.name) {
                    inclusive = true
                }
            }
        }

    }


    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        alignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .scale(scale.value)
    )

    Text(
        stringResource(id = R.string.app_name),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 44.sp,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(36.dp)
    )
    Text(
        stringResource(id = R.string.app_desc),
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(16.dp)
    )
}


@Preview
@Composable
fun SplashScreenPreview() {
    NavelTheme {
        //SplashScreen(appName = R.string.app_name, appDesc = R.string.app_desc)

    }
}
