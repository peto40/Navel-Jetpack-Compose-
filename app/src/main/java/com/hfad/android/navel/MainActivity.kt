package com.hfad.android.navel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hfad.android.navel.navigation.BottomNavigation
import com.hfad.android.navel.navigation.BottomNavigationGraph
import com.hfad.android.navel.ui.theme.NavelTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavelTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreenView()
                }
            }
        }

    }

}


@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        BottomNavigationGraph(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    NavelTheme {
        MainScreenView()
    }
}