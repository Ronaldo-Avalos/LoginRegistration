package com.example.loginregistration.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginregistration.R
import com.example.loginregistration.components.NormalText
import com.example.loginregistration.components.BoldText
import com.example.loginregistration.components.CheckBoxComponent
import com.example.loginregistration.components.ClickableTextComponent
import com.example.loginregistration.components.MyTextField
import com.example.loginregistration.components.PasswordTextField

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
        ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            NormalText(value = stringResource(id = R.string.hey) )
            BoldText(value = stringResource(id = R.string.creacuenta))
            Spacer(modifier = Modifier.height(30.dp))
          MyTextField(
              labelValue = stringResource(id = R.string.name),
              onTextChanged = {},
              painterResult = painterResource(id = R.drawable.profile))
            Spacer(modifier = Modifier.height(16.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.lastname),
                onTextChanged = {},
                painterResult = painterResource(id = R.drawable.profile))
            Spacer(modifier = Modifier.height(16.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                onTextChanged = {},
                painterResult = painterResource(id = R.drawable.message))
            Spacer(modifier = Modifier.height(16.dp))
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                onTextChanged = {},
                painterResult = painterResource(id = R.drawable.lock))
            CheckBoxComponent(value = stringResource(id = R.string.Politicas))


        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()

}
