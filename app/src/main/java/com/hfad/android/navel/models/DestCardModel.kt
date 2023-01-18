package com.hfad.android.navel.models

import com.hfad.android.navel.R

sealed class DestCardModel(
    val name: String,
    val type: String,
    val location: LocationModel,
    val rating: Double,
    val addedToBookmark: Boolean,
    val imageUri: Int,
){
    object BorobudurTemple : DestCardModel(
        name = "Borobudur",
        type = "Temple",
        location = LocationModel("Indonesia","Magelang", R.drawable.indonesia_flag),
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.borobudur_temple
    )
    object ZionNationalPark : DestCardModel(
        name = "Zion",
        type = "National Park",
        location = LocationModel("US","Springdale", R.drawable.us_flag),
        rating = 4.7,
        addedToBookmark = false,
        imageUri = R.drawable.zion_national_park
    )
    object KomodoIsland : DestCardModel(
        name = "Komodo",
        type = "Island",
        location = LocationModel("Indonesia","East Java", R.drawable.indonesia_flag),
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.komodo_island
    )
    object KutaBeach : DestCardModel(
        name = "Kuta",
        type = "Beach",
        location = LocationModel("Indonesia","Bali", R.drawable.indonesia_flag),
        rating = 4.8,
        addedToBookmark = false,
        imageUri = R.drawable.kuta_beach
    )
}

data class LocationModel(
    val country: String,
    val city: String,
    val flag: Int
)

