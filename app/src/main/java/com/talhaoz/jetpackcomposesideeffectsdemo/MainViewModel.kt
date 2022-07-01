package com.talhaoz.jetpackcomposesideeffectsdemo

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var state = mutableStateOf<ResultState>(ResultState.Idle)

    init {
        state.value = ResultState.Idle
    }

    fun getStartingDataFromAPI(functionName: String) {
        Log.d(functionName, "GET DATA API CALLED !!!")
        state.value = ResultState.StartingDataCalled
    }

    fun increaseCount(functionName: String) {
        Log.d(functionName, "INCREASE API CALLED !!!")
        state.value = ResultState.IncreaseDataCalled
    }
}