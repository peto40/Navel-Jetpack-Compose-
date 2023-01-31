package com.hfad.android.navel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.hfad.android.navel.ui.navigation.BottomNavigation
import com.hfad.android.navel.ui.navigation.BottomNavigationGraph
import com.hfad.android.navel.ui.theme.NavelTheme
import com.hfad.android.navel.ui.viewmodel.BookmarkViewModel
import com.hfad.android.navel.ui.viewmodel.BookmarkViewModelFactory


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

    val viewModel: BookmarkViewModel = viewModel(
    factory = BookmarkViewModelFactory(LocalContext.current.applicationContext)
    )

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        BottomNavigationGraph(navController = navController,viewModel = viewModel)
    }
}
