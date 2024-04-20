package com.example.trelloapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trelloapp.data.Result
import com.example.trelloapp.viewmodel.AuthViewModel

@Composable
fun LoginScreen( authViewModel: AuthViewModel,onNavigateToSignUp:() -> Unit,onSignInSuccess: () -> Unit){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val result by authViewModel.authResult.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Here",
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp),
            fontFamily = FontFamily.Monospace,
            )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email",
                fontFamily = FontFamily.Monospace
                )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password",
                fontFamily = FontFamily.Monospace
                )},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Button(
            onClick = {
              authViewModel.login(email, password)
                when (result) {
                    is Result.Success->{
                        onSignInSuccess()
                    }
                    is Result.Error-> {

                    }
                else -> {

                }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Text("Login",
                fontFamily = FontFamily.Monospace
                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Don't have an account? Sign Up.",
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.clickable { onNavigateToSignUp() }
        )
    }
}

@Preview
@Composable
fun LoginPreview(){
//    LoginScreen()
}