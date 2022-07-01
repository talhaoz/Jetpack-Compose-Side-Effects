package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import android.util.Log
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope()
    //  In order to launch a coroutine outside of a composable,
    //  but scoped so that it will be automatically canceled once it leaves the composition
    Button(onClick = {
        scope.launch {
            delay(1000L)
            Log.d("RememberCoroutineScope", "")
        }
    }) {

    }
}