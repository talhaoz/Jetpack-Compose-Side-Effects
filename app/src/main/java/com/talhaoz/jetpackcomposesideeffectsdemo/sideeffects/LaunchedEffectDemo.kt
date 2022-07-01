package com.talhaoz.jetpackcomposesideeffectsdemo.sideeffects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talhaoz.jetpackcomposesideeffectsdemo.MainViewModel
import com.talhaoz.jetpackcomposesideeffectsdemo.ResultState
import com.talhaoz.jetpackcomposesideeffectsdemo.getRandomColor

@Composable
fun LaunchedEffectDemo(
    startingDataCounter: MutableState<Int>,
    increaseCounter: MutableState<Int>,
    viewModel: MainViewModel
) {

    val text by remember {
        mutableStateOf("")
    }

    // pass any key parameter that will be a state for the LaunchedEffect (multiple keys can be passed)
    // Whenever this text state changes this coroutine will be cancelled and relaunched with the new text value
    // P.S. = If you would like to make it launch only once pass "Unit" as parameter
    LaunchedEffect(key1 = Unit) {
        viewModel.getStartingDataFromAPI("LaunchedEffect")
        //Thread.sleep(500L) // to see recomposition changes on the demo
    }

    val state = viewModel.state.value
    var bgColor = Color.Gray

    // To observe increasing value changes
    when (state) {
        ResultState.StartingDataCalled -> {
            startingDataCounter.value++
            bgColor = getRandomColor()
            viewModel.state.value = ResultState.Idle
        }
        ResultState.IncreaseDataCalled -> {
            increaseCounter.value++
            viewModel.state.value = ResultState.Idle
        }
        ResultState.Error -> {}
    }


    Text(
        text = "Starting Data API Call Count = ${startingDataCounter.value}",
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.padding(10.dp))

    Text(
        text = "Increase Number = ${increaseCounter.value}",
        color = Color.White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.padding(10.dp))

    LaunchedEffectDemoColumn(viewModel, bgColor)
}

@Composable
fun LaunchedEffectDemoColumn(
    viewModel: MainViewModel,
    bgColor: Color
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
            .background(bgColor)
            .padding(4.dp)
    ) {
        Text("Without LaunchedEffect", color = Color.White)
        Spacer(modifier = Modifier.padding(10.dp))
        IncreaseNumberAPIButton {
            viewModel.increaseCount("LaunchedEffect")
        }
    }
}

@Composable
fun IncreaseNumberAPIButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = "Increase Number API",
            textAlign = TextAlign.Center
        )
    }
}