package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun DerivedStateOfDemo() {
    var counter by remember {
        mutableStateOf(0)
    }

    // with this use everytime counterText is called from somewhere it will be recalculated(set) again
    //val counterText = "The counter is $counter"

    // with derivedState, it will cash the value and only update it when counter value changes
    // if counter text called from somewhere it will fetch
    val counterText by derivedStateOf {
        "The counter is $counter"
    }

    Button(onClick = { counter++ }) {
        Text(text = counterText)
    }
}