package com.example.trelloapp.screen

sealed class Screen(val route: String){
    object LoginScreen:Screen("loginscreen")
    object SignupScreen:Screen("signupscreen")
    object ChatRoomsScreen:Screen("chatroomscreen")
    object chatScreen:Screen("chatscreen")
}