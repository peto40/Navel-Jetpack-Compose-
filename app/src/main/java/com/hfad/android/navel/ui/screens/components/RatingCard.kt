package com.hfad.android.navel.ui.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.hfad.android.navel.R
import com.hfad.android.navel.ui.theme.AppTheme

@Composable
fun RatingCard(modifier: Modifier = Modifier, rating: Double) {


    Card(modifier = modifier
        .padding(top = 25.dp, start = 25.dp)
        .size(width = 78.dp, height = 32.dp),
        shape = RoundedCornerShape(32),
        elevation = 0.dp,
        backgroundColor = AppTheme.colors.actionButtonBackground
    ) {

        Box(modifier = modifier.fillMaxSize()) {

            Row(Modifier.align(Alignment.Center)) {

                Image(modifier = Modifier
                    .size(14.dp)
                    .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null)

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp),
                    text = rating.toString(),
                    color = AppTheme.colors.primaryBackground,
                    fontStyle = FontStyle.Italic,
                    )
            }
        }
    }
}

