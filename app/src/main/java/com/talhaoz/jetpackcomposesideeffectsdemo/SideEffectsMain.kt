package com.talhaoz.jetpackcomposesideeffectsdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects.LaunchedEffectDemo
import com.talhaoz.jetpackcomposesideeffectsdemo.ui.theme.JetpackComposeSideEffectsDemoTheme

@Preview(showBackground = true)
@Composable
fun SideEffectsPreview() {
    JetpackComposeSideEffectsDemoTheme {
        SideEffectsMain()
    }
}

@Composable
fun SideEffectsMain() {

    val startingDataCounterLaunchedEffect = remember { mutableStateOf(0) }
    val increaseCounterLaunchedEffect = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(0.dp, 50.dp)
    ) {
        LaunchedEffectDemo(
            startingDataCounterLaunchedEffect,
            increaseCounterLaunchedEffect,
            MainViewModel()
        )

        //RememberCoroutineScopeDemo()

        /* RememberUpdatedStateDemo {
             // TODO something you need
         }*/

        //DisposableEffectDemo()

        //SideEffectDemo()

        //ProduceStateDemo(url = "", imageRepository = ImageRepository())

        //DerivedStateOfDemo()

        //SnapshotFlowDemo()
    }
}

