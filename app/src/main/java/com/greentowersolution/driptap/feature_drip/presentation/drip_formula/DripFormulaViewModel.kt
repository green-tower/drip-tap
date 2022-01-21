package com.greentowersolution.driptap.feature_drip.presentation.drip_formula

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.greentowersolution.driptap.feature_drip.domain.use_case.DripFormula
import java.lang.NumberFormatException

class DripFormulaViewModel(
    private val dripForuma: DripFormula = DripFormula()
) : ViewModel() {

    var volume = mutableStateOf("")
    var hours = mutableStateOf("")
    var useMicroDrips = mutableStateOf(false)
    var resultHowMuchDripsPerMinute = mutableStateOf(0L)

    fun dripFormula() {
        resultHowMuchDripsPerMinute.value = dripForuma.invoke(
            volume = volume.value.toLong(),
            hours = hours.value.toLong(),
            useMicroDrips = useMicroDrips.value
        )
    }

    fun isValid(): Boolean {
        try {
            volume.value.toLong()
        } catch (e: NumberFormatException) {
            return false
        }
        try {
            hours.value.toLong()
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }
}
