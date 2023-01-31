package com.hfad.android.navel.data.models

import com.hfad.android.navel.R

data class ProductTourSlideModel(
    val title: Int,
    val indicatorState: Int,
    val image: Int,
)

val models = listOf(
    ProductTourSlideModel(
        title = R.string.first_scr,
        indicatorState = 1,
        image = R.drawable.tour1
    ),
    ProductTourSlideModel(
        title = R.string.second_scr,
        indicatorState = 2,
        image = R.drawable.tour2
    ),
    ProductTourSlideModel(
        title = R.string.third_scr,
        indicatorState = 3,
        image = R.drawable.tour3
    )
)