package com.example.loginregistration.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginregistration.R
import com.example.loginregistration.ui.theme.ColorField
import com.example.loginregistration.ui.theme.ColorText
import com.example.loginregistration.ui.theme.Primary
import com.example.loginregistration.ui.theme.QuickSand
import com.example.loginregistration.ui.theme.componentShapes
import kotlin.math.log

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String, onTextChanged: (String) -> Unit,painterResult: Painter) {
    val password = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }

    OutlinedTextField(
        label = { Text(text = labelValue)},
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = password.value,
        onValueChange = { newValue ->
            password.value = newValue
            onTextChanged(newValue)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            containerColor = ColorField

        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(painterResult, contentDescription = "IconUserRegister")
        },
        trailingIcon = {
            val iconImage = if (passwordVisibility.value){
            Icons.Filled.Visibility
            } else{
                Icons.Filled. VisibilityOff
            }
            val description = if (passwordVisibility.value){
                "Hide password"
            }else{
                "Show password"
            }
            IconButton(onClick = {passwordVisibility.value = !passwordVisibility.value }) {
                Icon(imageVector =iconImage, contentDescription = description )
            }
        },
        visualTransformation =  if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent (value: String) {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .heightIn(56.dp)
           .padding(16.dp),
       verticalAlignment = Alignment.CenterVertically)
   {
       val checkedState = remember {
           mutableStateOf(false)
       }
       Checkbox(checked = checkedState.value,
           onCheckedChange = {
               checkedState.value = !checkedState.value
           })

       ClickableTextComponent(value = value)
   }
}

@Composable
fun ClickableTextComponent(value: String){
    val InicioText = stringResource(R.string.aceptarP)
    val PoliticaPrivacidadText = stringResource(R.string.Politicas)
    val yText  = stringResource(R.string.y)
    val TerminosCondiciones = stringResource(R.string.terminos_y_condiciones)

    val annotatedString = buildAnnotatedString {
     append(InicioText)
        withStyle(style = SpanStyle(color = ColorText)){
                pushStringAnnotation(tag = PoliticaPrivacidadText, annotation = PoliticaPrivacidadText)
                append(PoliticaPrivacidadText)
            }
        append(yText)
        withStyle(style = SpanStyle(color = ColorText)){
            pushStringAnnotation(tag = TerminosCondiciones, annotation = TerminosCondiciones)
            append(TerminosCondiciones)
        }
    }

    ClickableText(text = annotatedString, onClick = {offet ->
        annotatedString .getStringAnnotations(offet,offet).firstOrNull()?.also { span ->
            Log.d("CheckBoxComponentACTIVO", "{$span}")
        }
    })
}