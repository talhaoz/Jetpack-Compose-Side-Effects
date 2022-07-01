package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

@Composable
fun SnapshotFlowDemo() {
    val scaffoldState = rememberScaffoldState()

    // snapshotFlow basically is the opposite of collectAsState method
    // It us used to get flow out of compose state
    LaunchedEffect(key1 = scaffoldState) {
        snapshotFlow { scaffoldState.snackbarHostState }
            .mapNotNull { it.currentSnackbarData?.message }
            .distinctUntilChanged()
            .collect { text ->
                println("A snackbar $text has displayed")
            }
    }
}