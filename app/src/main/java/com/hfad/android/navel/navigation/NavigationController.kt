package com.hfad.android.navel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hfad.android.navel.models.UserModel
import com.hfad.android.navel.screens.*
import com.hfad.android.navel.screens.home.BookmarkScreen
import com.hfad.android.navel.screens.home.HomeScreen
import com.hfad.android.navel.screens.home.MapScreen
import com.hfad.android.navel.screens.home.ProfileScreen
import com.hfad.android.navel.screens.login.screens.*
import com.hfad.android.navel.utils.BottomNavItem
import com.hfad.android.navel.utils.Screen

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.name
    ) {
        composable(route = Screen.Welcome.name) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.ProductTour.name) {
            ProductTourScreen(navController = navController)
        }
        composable(route = Screen.Login.name) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Register.name) {
            RegisterScreen(navController = navController)
        }
        composable(route = Screen.AccountSetup.name) {
            navController.previousBackStackEntry?.arguments?.getParcelable<UserModel?>(
                CURRENT_USER_KEY)
                .let {
                    if (it != null) {
                        AccountSetupScreen(
                            navController = navController,
                            currentUser = it
                        )
                    }
                }
        }
        composable(route = Screen.RegisterComplete.name) {
            navController.previousBackStackEntry?.arguments?.getParcelable<UserModel?>(
                CURRENT_USER_KEY)
                .let {
                    AccountSetupIsComplete(currentUser = it)
                }
        }

    }
}

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {

        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
//            HomeScreen(currentUser = UserModel())
        }
        composable(BottomNavItem.Map.screen_route) {
            MapScreen()
        }
        composable(BottomNavItem.Bookmark.screen_route) {
            BookmarkScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen()
        }

    }
}