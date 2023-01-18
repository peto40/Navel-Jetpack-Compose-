package com.hfad.android.navel.screens.login.screens

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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hfad.android.navel.R
import com.hfad.android.navel.screens.components.inputTextField
import com.hfad.android.navel.screens.login.DataStorePref
import com.hfad.android.navel.screens.login.Login
import com.hfad.android.navel.ui.theme.AppTheme
import com.hfad.android.navel.ui.theme.Colors
import com.hfad.android.navel.utils.Screen
import kotlinx.coroutines.launch

const val PASSWORD_KEY = "password_key"
const val EMAIL_KEY = "email_key"

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val mContext = LocalContext.current
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        Box(modifier = modifier
            .fillMaxWidth()
            .height(440.dp)) {

            Image(painter = painterResource(R.drawable.login_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize())

//            Location(text = R.string.bali_indonesia,
//                modifier = modifier
//                    .padding(top = 18.dp, end = 24.dp)
//                    .align(Alignment.TopEnd)
//            )
        }
        Box(modifier = modifier.padding(top = 178.dp)) {

            Image(painter = painterResource(R.drawable.fading),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize())

            Text(color = AppTheme.colors.headerTextColor,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.login),
                modifier = modifier
                    .align(alignment = Alignment.TopStart)
                    .padding(top = 141.dp, start = 35.dp))

            Column(modifier = modifier
                .padding(top = 262.dp)
                .fillMaxSize()


            ) {
                var emailHint by remember { mutableStateOf("Email ID") }
                var passwordHint by remember { mutableStateOf("Password") }
                var emailHintColor by remember { mutableStateOf(Color.Black) }
                var passwordHintColor by remember { mutableStateOf(Color.Black) }


                val email = inputTextField(icon = Icons.Default.Email, desc = emailHint, emailHintColor)
                val password = inputTextField(
                    icon = Icons.Default.Lock,
                    desc = passwordHint, passwordHintColor,
                    vt = PasswordVisualTransformation(),
                    keyboardType = KeyboardType.Password
                )

                Row(modifier = modifier) {
                    Button(modifier = modifier
                        .size(width = 254.dp, height = 68.dp)
                        .padding(start = 24.dp, top = 16.dp),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                        onClick = {
                            if (email.isEmpty()) {
                                emailHintColor = Color.Red
                                emailHint = "Please enter an email."
                            }
                            if (password.isEmpty()) {
                                passwordHintColor = Color.Red
                                passwordHint = "Please enter an password."
                            } else {
                                Login(mContext).login(email = email, password = password)
                            }
                            scope.launch {
                                DataStorePref(mContext).saveEmail(key = EMAIL_KEY, value = email)
                                DataStorePref(mContext).savePassword(key = PASSWORD_KEY, value = password)
                            }
                        }) {
                        Text(stringResource(id = R.string.login),
                            color = AppTheme.colors.headerTextColor)
                    }
                    Button(modifier = modifier
                        .height(height = 68.dp)
                        .padding(start = 24.dp, top = 16.dp),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        onClick = { /*TODO*/ }) {
                        Text(stringResource(id = R.string.face_ID),
                            color = AppTheme.colors.headerTextColor)
                    }
                }

                Text(stringResource(id = R.string.login_with),
                    modifier = modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(top = 16.dp),
                    color = AppTheme.colors.primaryTintColor,
                    fontStyle = FontStyle.Normal,
                    fontSize = 14.sp)

                Row(modifier = modifier
                    .padding(horizontal = 62.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(modifier = modifier
                        .height(52.dp)
                        .width(114.dp),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.borderColor),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.google_icon),
                            contentDescription = null)
                    }

                    Button(modifier = modifier
                        .height(52.dp)
                        .width(114.dp),
                        colors = ButtonDefaults.buttonColors(AppTheme.colors.borderColor),
                        shape = RoundedCornerShape(CornerSize(14.dp)),
                        onClick = { /*TODO*/ }) {
                        Icon(painterResource(id = R.drawable.facebook_icon),
                            contentDescription = null)
                    }
                }

                Row(modifier = modifier
                    .padding(18.dp)
                    .align(alignment = CenterHorizontally)
                    .clickable {
                        navController.navigate(Screen.Register.name)
                    }) {
                    Text(text = "New User? ", color = AppTheme.colors.primaryTintColor)
                    Text(
                        stringResource(id = R.string.register_here),
                        fontStyle = FontStyle.Italic,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun LoginPreview() {
    //LoginScreen()
    inputTextField(icon = Icons.Default.Email, desc = "")
}