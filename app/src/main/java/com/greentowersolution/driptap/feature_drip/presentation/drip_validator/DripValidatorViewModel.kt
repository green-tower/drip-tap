package com.greentowersolution.driptap.feature_drip.presentation.drip_validator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DripValidatorViewModel() : ViewModel() {
    val countedDripsPerMinute = mutableStateOf(0L)

    fun countDrip() {
        countedDripsPerMinute.value++
    }

    fun resetDripCounter() {
        countedDripsPerMinute.value = 0L
    }
}