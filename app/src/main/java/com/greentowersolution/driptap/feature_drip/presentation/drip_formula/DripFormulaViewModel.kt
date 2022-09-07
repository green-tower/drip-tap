package com.greentowersolution.driptap.feature_drip.presentation.drip_formula

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.greentowersolution.driptap.feature_drip.domain.use_case.DripFormula

class DripFormulaViewModel(
    private val dripFormula: DripFormula = DripFormula()
) : ViewModel() {

    var volume = mutableStateOf("")
    var hours = mutableStateOf("")
    var useMicroDrips = mutableStateOf(false)
    var resultHowMuchDripsPerMinute = mutableStateOf(0L)

    fun dripFormula() {
        resultHowMuchDripsPerMinute.value = dripFormula.invoke(
            volume = volume.value.toLong(),
            hours = hours.value.toLong(),
            useMicroDrips = useMicroDrips.value
        )
    }

    fun isValid(): Boolean {
        try {
            volume.value.toLong()
        } catch (e: NumberFormatException) {
            volume.value = ""
            return false
        }
        try {
            hours.value.toLong()
        } catch (e: NumberFormatException) {
            hours.value = ""
            return false
        }
        return true
    }
}
