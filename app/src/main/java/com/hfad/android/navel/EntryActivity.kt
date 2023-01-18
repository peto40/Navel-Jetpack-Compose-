@file:JvmName("EntryActivityKt")

package com.hfad.android.navel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.hfad.android.navel.navigation.NavigationAppHost
import com.hfad.android.navel.ui.theme.NavelTheme

class EntryActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)


                }

            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavelTheme {
    //MainScreenView()
    }
}