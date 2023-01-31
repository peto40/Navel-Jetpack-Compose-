package com.hfad.android.navel.data.models

import com.hfad.android.navel.R

sealed class DestCardModel(
    val name: String,
    val type: String,
    val country: String,
    val city: String,
    val flag: Int,
    val rating: Double,
    val addedToBookmark: Boolean,
    val imageUri: Int,
){
    object BorobudurTemple : DestCardModel(
        name = "Borobudur",
        type = "Temple",
        country = "Indonesia",
        city = "Magelang",
        flag = R.drawable.indonesia_flag,
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.borobudur_temple
    )
    object ZionNationalPark : DestCardModel(
        name = "Zion",
        type = "National Park",
        country = "US",
        city = "Springdale",
        flag = R.drawable.us_flag,
        rating = 4.7,
        addedToBookmark = false,
        imageUri = R.drawable.zion_national_park
    )
    object KomodoIsland : DestCardModel(
        name = "Komodo",
        type = "Island",
        country = "Indonesia",
        city = "Java",
        flag = R.drawable.indonesia_flag,
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.komodo_island
    )
    object KutaBeach : DestCardModel(
        name = "Kuta",
        type = "Beach",
        country = "Indonesia",
        city = "Bali",
        flag = R.drawable.indonesia_flag,
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.kuta_beach
    )
}
