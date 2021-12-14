package com.greentowersolution.driptap.feature_drip.presentation.frequency_settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.greentowersolution.driptap.feature_drip.domain.use_case.ComputeDrips

class FrequencySettingsViewModel(
    private val computeDrips: ComputeDrips = ComputeDrips()
) : ViewModel() {

    var dripsPerMinute = mutableStateOf(0L)

    fun computeDrips() {
        dripsPerMinute.value = computeDrips.invoke()
    }
}
