package com.talhaoz.jetpackcomposesideeffectsdemo

sealed class ResultState {
    object StartingDataCalled : ResultState()
    object IncreaseDataCalled : ResultState()
    object Idle : ResultState()
    object Error : ResultState()
}