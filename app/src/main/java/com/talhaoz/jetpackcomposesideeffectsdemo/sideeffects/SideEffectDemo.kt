package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

var i = 0

@Composable
fun SideEffectDemo() {
    // it will launch after every successful recomposition
    SideEffect { //this will handle the side effect that may occur
        i++
    }
    Button(onClick = {}) {
        Text(text = "Click")
    }
}