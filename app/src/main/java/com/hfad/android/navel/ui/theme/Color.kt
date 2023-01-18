package com.hfad.android.navel.ui.theme

import androidx.compose.ui.graphics.Color
//
//val Purple200 = Color(0xFFBB86FC)
//val Purple500 = Color(0xFF6200EE)
//val Purple700 = Color(0xFF3700B3)
//val Teal200 = Color(0xFF03DAC5)
//
//val SoftGold = Color(0xFFFAD8B0)
//val Background = Color(0xFFFCDFBC)
//val Gold = Color(0xFFE7B171)
//val DarkGreen = Color(0xFF1B3232)
//val LightGreen = Color(0xFF415F5F)
//val Brown_2 = Color(0xFFB1A699)
//val DarkGrey_2 = Color(0xFF4D12332F)

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val primaryTextInvertColor: Color,
    val hintTextColor: Color,
    val primaryTintColor: Color,
    val accentColor: Color,
    val actionButtonBackground: Color,
    val borderColor: Color,
    val hiddenColor: Color,
    val colorless: Color

)

val lightPalette = Colors(
    primaryBackground = Color(0xFFFCDFBC),
    secondaryBackground = Color(0xFFFAD8B0),
    headerTextColor = Color(0xFF1B3232),
    primaryTextColor = Color.Black,
    primaryTextInvertColor = Color(0xFFFFFFFF),
    primaryTintColor = Color(0xFF415F5F),
    hintTextColor = Color(0x4D12332F),
    accentColor = Color(0xFFE7B171),
    actionButtonBackground = Color(0x60D6A266),
    borderColor = Color(0xFFFAD8B0),
    hiddenColor = Color(0xFFB1A699),
    colorless = Color(0X00FFFFFF)
)