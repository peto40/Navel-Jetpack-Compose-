package com.hfad.android.navel.screens.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.models.LocationModel
import com.hfad.android.navel.ui.theme.AppTheme

@Composable
fun Location(
    modifier: Modifier = Modifier,
    locationModel: LocationModel
) {
    val country = locationModel.country
    val city = locationModel.city
    val flag = locationModel.flag
    Row(modifier = modifier) {
        Image(modifier = modifier
            .size(13.dp)
            .align(CenterVertically),
            painter = painterResource(id = flag),
            contentDescription = null
        )

        Text(
            modifier = modifier.padding(start = 6.dp),
            text = country,
            fontSize = 14.sp,
            color = AppTheme.colors.hiddenColor,
        )
        Text(
            modifier = modifier.padding(start = 6.dp),
            text = city,
            fontSize = 14.sp,
            color = AppTheme.colors.hiddenColor,
        )
    }

}