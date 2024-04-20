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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trelloapp.viewmodel.AuthViewModel

@Composable
fun SignUpScreen(authViewModel: AuthViewModel,onNavigateToLogin:() -> Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register Here",
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            fontFamily = FontFamily.Monospace
        )
          OutlinedTextField(
              value = email,
              onValueChange = { email = it},
              label = { Text("Email",
                  fontFamily = FontFamily.Monospace
                  )},
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp)
              )
          OutlinedTextField(
              value = password,
              onValueChange = { password = it},
              label = { Text("Password",
                  fontFamily = FontFamily.Monospace
                  )},
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp)
          )
          OutlinedTextField(
              value = firstName,
              onValueChange = { firstName = it},
              label = { Text("First Name",
                  fontFamily = FontFamily.Monospace
                  )},
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp)
          )
          OutlinedTextField(
              value = lastName,
              onValueChange = { lastName = it},
              label = { Text("Last Name",
                  fontFamily = FontFamily.Monospace
                  )},
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp)
          )
          Button(
              onClick = {
                  authViewModel.signUp(email, password, firstName, lastName)
                  email = ""
                  password = ""
                  firstName = ""
                  lastName = ""
              },
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp),
          ){
              Text("Sign Up",
                  fontFamily = FontFamily.Monospace
                  )
          }
         Spacer(modifier = Modifier.height(16.dp))
         Text(text = "Already have a account? Sign in.",
             fontFamily = FontFamily.Monospace,
                modifier = Modifier.clickable { onNavigateToLogin() },
             )
    }
}
@Preview
@Composable
fun SignUpPreview(){
//    SignUpScreen()
}