package com.example.loginregistration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginregistration.ui.theme.ColorField
import com.example.loginregistration.ui.theme.ColorText
import com.example.loginregistration.ui.theme.Primary
import com.example.loginregistration.ui.theme.QuickSand
import com.example.loginregistration.ui.theme.componentShapes

@Composable
//Sera un texto sencillo que podemos usar en toda nuestra aplicación
fun NormalText(value: String){
     Text(
         text = value,
         modifier = Modifier
             .fillMaxWidth()
             .heightIn(min = 30.dp),
         style = TextStyle(
             fontFamily = QuickSand,
             fontSize = 20.sp,
             fontWeight = FontWeight.W400,
             fontStyle = FontStyle.Normal,
         ),
         color = ColorText,
         textAlign = TextAlign.Center
     )
}
@Composable
fun BoldText(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontFamily = QuickSand,
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            fontStyle = FontStyle.Normal
        ),
        color = ColorText,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue: String, onTextChanged: (String) -> Unit,painterResult: Painter) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        label = { Text(text = labelValue)},
        modifier = Modifier
           .fillMaxWidth()
            .clip(componentShapes.small),
        value = textValue.value,
        onValueChange = { newValue ->
            textValue.value = newValue
            onTextChanged(newValue)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = ColorField

        ),
        keyboardOptions = KeyboardOptions.Default,
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(painterResult, contentDescription = "IconUserRegister")
        }
    )
}
