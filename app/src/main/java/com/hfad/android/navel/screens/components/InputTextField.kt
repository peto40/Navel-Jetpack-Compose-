package com.hfad.android.navel.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.hfad.android.navel.ui.theme.AppTheme


@Composable
fun inputTextField(
    icon: ImageVector,
    desc: String,
    hintColor: Color = Color.Black,
    modifier: Modifier = Modifier,
    vt: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Email
) : String {
    var textState by remember { mutableStateOf("") }

    TextField(
        value = textState,
        onValueChange = { newText ->
            textState = newText
        },
        leadingIcon = {
            Icon(icon, contentDescription = null)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = AppTheme.colors.primaryBackground,
            disabledIndicatorColor = AppTheme.colors.secondaryBackground,
            errorIndicatorColor = AppTheme.colors.secondaryBackground,
            focusedIndicatorColor = AppTheme.colors.accentColor,
            unfocusedIndicatorColor = AppTheme.colors.secondaryBackground
        ),
        placeholder = { Text(text = desc, color = hintColor) },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .padding(horizontal = 16.dp)
            .padding(top = 12.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        visualTransformation = vt
    )
    return textState

}
