package com.greentowersolution.driptap.feature_drip.presentation.drip_formula

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.greentowersolution.driptap.feature_drip.domain.use_case.DripFormula

class DripFormulaViewModel(
    private val dripForuma: DripFormula = DripFormula()
) : ViewModel() {

    var volume = mutableStateOf(0L)
    var hours = mutableStateOf(0L)
    var useMicroDrips = mutableStateOf(false)
    var resultHowMuchDripsPerMinute = mutableStateOf(0L)

    fun dripFormula() {
        resultHowMuchDripsPerMinute.value = dripForuma.invoke(
            volume = volume.value,
            hours = hours.value,
            useMicroDrips = useMicroDrips.value
        )
    }
}
