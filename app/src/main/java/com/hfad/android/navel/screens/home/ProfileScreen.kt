package com.hfad.android.navel.screens.home

import android.widget.ActionMenuView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hfad.android.navel.R
import com.hfad.android.navel.models.LocationModel
import com.hfad.android.navel.screens.components.Location
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.ui.theme.Shapes


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        backgroundColor = AppTheme.colors.primaryBackground
    ) {

        Column(modifier = modifier.padding(30.dp)) {
            UserInformation(modifier = modifier)
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 27.dp)
                    .height(64.dp),
                backgroundColor = AppTheme.colors.borderColor,
                shape = RoundedCornerShape(15)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = CenterVertically
                ) {
                    Text(
                        modifier = modifier.padding(start = 25.dp),
                        fontSize = 14.sp,
                        color = AppTheme.colors.primaryTintColor,
                        fontWeight = FontWeight.Normal,
                        text = "Your Profile"
                    )
                    IconButton(
                        modifier = modifier
                            .padding(end = 12.dp)
                            .border(BorderStroke(1.dp, AppTheme.colors.accentColor))
                            .size(40.dp),
                        onClick = { /*TODO*/ },
                        ) {
                        Icon(
                            modifier = modifier,
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
            }
            ActionButton(modifier = modifier.padding(top = 99.dp),actionName = "Promotion")
            ActionButton(modifier = modifier.padding(),actionName = "Payment")
            ActionButton(modifier = modifier.padding(),actionName = "Setting")
            ActionButton(modifier = modifier.padding(),actionName = "Booking List")
            ActionButton(modifier = modifier.padding(),actionName = "Logout")
        }
    }
}

@Composable
fun UserInformation(modifier: Modifier = Modifier) {

    Row(modifier = modifier.height(80.dp).fillMaxWidth()) {
        Surface(
            modifier = modifier.size(80.dp), shape = RoundedCornerShape(23)
        ) {
            Icon(
                modifier = modifier.fillMaxSize(),
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
        }
        Column(modifier = modifier.align(CenterVertically)) {
            Text(
                text = "Evelyn",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = AppTheme.colors.headerTextColor,
                modifier = modifier.padding(start = 16.dp),
                textAlign = TextAlign.Center,
            )

            Location(
                modifier = Modifier.padding(start = 16.dp), locationModel = LocationModel(
                    "Indonesia", "Bali", R.drawable.indonesia_flag
                )
            )
        }
    }
}

@Composable
fun ActionButton(modifier: Modifier = Modifier, actionName: String) {

    IconButton(
        modifier = modifier
            .height(64.dp)
            .fillMaxWidth(),
        onClick = { /*TODO*/ },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(start = 25.dp, top = 20.dp),
                    text = actionName,
                    fontSize = 16.sp,
                    color = AppTheme.colors.primaryTintColor,
                    fontWeight = FontWeight.Normal,
                )

                Icon(
                    modifier = Modifier.padding(end = 12.dp, top = 20.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null)
            }
            Row(modifier = Modifier.height(1.dp).fillMaxWidth().background(AppTheme.colors.hintTextColor)){}
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}