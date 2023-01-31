@file:JvmName("EntryActivityKt")

package com.hfad.android.navel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hfad.android.navel.ui.navigation.NavigationAppHost
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