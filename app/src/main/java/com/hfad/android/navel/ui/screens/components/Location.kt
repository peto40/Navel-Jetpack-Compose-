package com.hfad.android.navel.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.ui.theme.AppTheme

@Composable
fun Location(
    modifier: Modifier = Modifier,
    country: String,
    city: String,
    flag: Int
) {

    Row(modifier = modifier) {
        Image(modifier = Modifier
            .size(13.dp)
            .align(CenterVertically),
            painter = painterResource(id = flag),
            contentDescription = null
        )

        Text(
            modifier = Modifier.padding(start = 6.dp),
            text = country,
            fontSize = 14.sp,
            color = AppTheme.colors.hiddenColor,
        )
        Text(
            modifier = Modifier.padding(start = 6.dp),
            text = city,
            fontSize = 14.sp,
            color = AppTheme.colors.hiddenColor,
        )
    }

}