package com.hfad.android.navel.utils

import com.hfad.android.navel.R

enum class Screen {
     Welcome,
     Login,
     Register,
     AccountSetup,
     ProductTour,
     RegisterComplete
}

sealed class BottomNavItem(var title:String, var icon: Int, var screen_route:String) {

    object Home : BottomNavItem("Home", R.drawable.home_icon,"home")
    object Map: BottomNavItem("Map",R.drawable.map_icon,"map")
    object Bookmark: BottomNavItem("Bookmark",R.drawable.bookmark_icon,"bookmark")
    object Profile: BottomNavItem("Profile", R.drawable.person_icon,"profile")
}

