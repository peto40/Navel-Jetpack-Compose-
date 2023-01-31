package com.hfad.android.navel.ui.screens.login.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.hfad.android.navel.R
import com.hfad.android.navel.models.UserModel
import com.hfad.android.navel.ui.navigation.navigate
import com.hfad.android.navel.ui.screens.components.inputTextField
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.utils.Screen

const val CURRENT_USER_KEY = "current_user_key"

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    Box(modifier = modifier) {
        Box(modifier = modifier
            .height(height = 440.dp)
            .fillMaxWidth()) {

//            Location(text = R.string.bali_indonesia,
//                modifier = modifier
//                    .padding(top = 18.dp, end = 24.dp)
//                    .align(Alignment.TopEnd)
//            )

            Image(painter = painterResource(R.drawable.register_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }

        Box(modifier = modifier.padding(top = 178.dp)) {

            Image(painter = painterResource(R.drawable.fading),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize())

            Text(color = AppTheme.colors.headerTextColor,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.register),
                modifier = modifier
                    .align(alignment = Alignment.TopStart)
                    .padding(top = 141.dp, start = 35.dp))

            Column(modifier = modifier
                .padding(top = 216.dp)
                .fillMaxSize()
            ) {
                val fullName = inputTextField(icon = Icons.Default.Person, "Full Name")
                val email = inputTextField(icon = Icons.Default.Email, "Email ID")
                val password = inputTextField(
                    icon = Icons.Default.Lock,
                    desc = "Password",
                    vt = PasswordVisualTransformation(),
                    keyboardType = KeyboardType.Password
                )

                val user = UserModel(fullName = fullName, email = email, password = password)

                Button(modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .width(68.dp),
                    shape = RoundedCornerShape(CornerSize(14.dp)),
                    colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                    onClick = {
                        navController.navigate(
                            route = Screen.AccountSetup.name,
                            bundleOf(CURRENT_USER_KEY to user)
                        )
                    }
                ) {
                    Text(
                        stringResource(id = R.string.register),
                        modifier = modifier.padding(8.dp),
                        color = AppTheme.colors.headerTextColor)
                }

                Text(stringResource(id = R.string.register_with),
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally),
                    color = AppTheme.colors.primaryTintColor,
                    fontStyle = FontStyle.Normal,
                    fontSize = 14.sp
                )

                Row(modifier = modifier
                    .padding(horizontal = 62.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(modifier = modifier
                        .height(52.dp)
                        .width(114.dp),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.borderColor),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(painterResource(id = R.drawable.google_icon),
                            contentDescription = null)
                    }

                    Button(modifier = modifier
                        .height(52.dp)
                        .width(114.dp),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.borderColor),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(painterResource(id = R.drawable.facebook_icon),
                            contentDescription = null)

                    }
                }

                Row(modifier = modifier
                    .padding(4.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable {
                        navController.navigate(Screen.Login.name)
                    }) {
                    Text(text = "Already have an account? ",
                        color = AppTheme.colors.primaryTintColor)
                    Text(
                        text = "Login Here",
                        fontStyle = FontStyle.Italic,
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    //RegisterScreen()
}