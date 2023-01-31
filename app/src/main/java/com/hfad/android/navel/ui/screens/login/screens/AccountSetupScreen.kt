package com.hfad.android.navel.ui.screens.login.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.hfad.android.navel.R
import com.hfad.android.navel.models.UserModel
import com.hfad.android.navel.ui.navigation.navigate
import com.hfad.android.navel.ui.screens.components.inputTextField
import com.hfad.android.navel.ui.screens.login.Login
import com.hfad.android.navel.ui.screens.login.Register
import com.hfad.android.navel.ui.theme.*
import com.hfad.android.navel.utils.Screen

@Composable
fun AccountSetupScreen(
    modifier: Modifier = Modifier,
    @StringRes accSetup: Int = R.string.acc_setup,
    @StringRes description: Int = R.string.description,
    currentUser: UserModel,
    navController: NavController,
) {
    var selectedImage by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        selectedImage = uri
    }
    Column(modifier = modifier
        .fillMaxSize()
        .background(AppTheme.colors.primaryBackground)
    ) {

        Text(
            stringResource(id = accSetup),
            color = AppTheme.colors.headerTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 38.sp,
            modifier = modifier.padding(top = 146.dp, start = 32.dp, end = 193.dp)
        )
        Text(
            stringResource(id = description),
            color = AppTheme.colors.headerTextColor,
            modifier = modifier.padding(horizontal = 32.dp, vertical = 25.dp))

        Box(modifier = modifier
            .align(CenterHorizontally)
            .padding(32.dp)
        ) {

            Card(
                modifier = modifier
                    .padding(24.dp)
                    .size(117.dp),
                shape = CircleShape,
                border = BorderStroke(3.dp, AppTheme.colors.secondaryBackground),
            ) {
                if (selectedImage != null) {
                    ImageContent(selectedImage = selectedImage)
                } else {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = modifier
                            .background(AppTheme.colors.primaryBackground)
                            .clip(CircleShape)
                    )
                }
            }
            Button(
                colors = ButtonDefaults.buttonColors(AppTheme.colors.secondaryBackground),
                modifier = modifier
                    .align(Alignment.BottomEnd)
                    .size(52.dp),
                onClick = {
                    launcher.launch("image/jpeg")
                }
            ) {
                Icon(
                    painterResource(id = R.drawable.upload_button),
                    tint = AppTheme.colors.accentColor,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(0.dp),
                    contentDescription = null
                )
            }
        }

        val userName = inputTextField(icon = Icons.Default.Person, desc = "", hintColor = Color.Black)

        currentUser.imageUri = selectedImage
        currentUser.userName = userName

        Row(modifier = modifier.fillMaxHeight()) {
            Button(
                colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                modifier = modifier
                    .fillMaxWidth()
                    .height(82.dp)
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .align(Bottom),
                shape = RoundedCornerShape(CornerSize(14.dp)),
                onClick = {
                    val name = currentUser.fullName
                    val email = currentUser.email
                    val password = currentUser.password
                    //Log.d("55555", selectedImage.toString())
                    Register().createUser(name,email,password)
                    navController.navigate(route = Screen.RegisterComplete.name,
                        bundleOf(CURRENT_USER_KEY to currentUser))
                }
            ) {
                Text(stringResource(id = R.string.create_account))
            }
        }
    }
}

@Composable
fun AccountSetupIsComplete(
    modifier: Modifier = Modifier,
    currentUser: UserModel?
) {
    Box(modifier = modifier) {

        Box(modifier = modifier
            .fillMaxWidth()
            .height(440.dp)) {

            Image(painter = painterResource(R.drawable.register_complete),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize())
        }

        Box(modifier = modifier.padding(top = 178.dp)) {
            Image(painter = painterResource(R.drawable.fading),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize())
            Column(
                modifier = modifier
                    .padding(top = 16.dp)
                    .fillMaxSize()
            ) {


                Text(
                    stringResource(id = R.string.reg_complete),
                    color = AppTheme.colors.headerTextColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 38.sp,
                    modifier = modifier.padding(top = 0.dp, start = 32.dp, end = 183.dp)
                )
                Text(
                    stringResource(id = R.string.succes_desc),
                    color = AppTheme.colors.headerTextColor,
                    modifier = modifier.padding(horizontal = 32.dp, vertical = 25.dp))


                Card(
                    modifier = modifier
                        .padding(44.dp)
                        .size(157.dp)
                        .align(CenterHorizontally)
                        .shadow(
                            ambientColor = AppTheme.colors.headerTextColor,
                            elevation = 16.dp,
                            spotColor = AppTheme.colors.headerTextColor,
                            shape = CircleShape
                        ),
                    shape = CircleShape,
                    border = BorderStroke(3.dp, AppTheme.colors.borderColor),
                ) {
                    if (currentUser?.imageUri != null) {
                        ImageContent(currentUser.imageUri)
                    } else {
                        Icon(modifier = modifier.padding(8.dp),
                            imageVector = Icons.Default.Person,
                            contentDescription = null)
                    }
                }
                currentUser?.fullName?.let {
                    Text(text = it,
                        fontSize = 32.sp,
                        modifier = modifier
                            .align(CenterHorizontally)

                    )
                }
            }

        }

        val mContext = LocalContext.current
        Row(modifier = modifier.fillMaxHeight()) {
            Button(
                colors = ButtonDefaults.buttonColors(AppTheme.colors.accentColor),
                modifier = modifier
                    .fillMaxWidth()
                    .height(82.dp)
                    .padding(horizontal = 32.dp, vertical = 16.dp)
                    .align(Bottom),
                shape = RoundedCornerShape(CornerSize(14.dp)),
                onClick = {
                    Login(mContext).login(
                        email = currentUser?.email.toString(),
                        password = currentUser?.password.toString()
                    )
                }
            ) {
                Text(stringResource(id = R.string.explore_home))
            }
        }
    }

}

@Composable
fun ImageContent(
    selectedImage: Uri? = null,
) {
    Scaffold() {
        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(selectedImage),
                contentDescription = "Selected image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )

        }
    }
}

@Preview
@Composable
fun AccountSetupScreenPreview() {
//    AccountSetupScreen(
//        accSetup = R.string.acc_setup,
//        description = R.string.description
//    )
}

@Preview
@Composable
fun AccountSetupSelectedScreenPreview() {
//    AccountSetupIsComplete()
}
