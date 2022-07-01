package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
) {
    // This will always refer to the latest onTimeout function
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)

    // In here i.g. we have a landing screen that triggers a function after some delay,
    // If LandingScreen recomposes, the delay shouldn't start again.
    // To prevent that we are using rememberUpdatedState which stores the last value
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}