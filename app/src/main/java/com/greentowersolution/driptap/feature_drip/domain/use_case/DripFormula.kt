package com.greentowersolution.driptap.feature_drip.domain.use_case

import androidx.compose.runtime.MutableState

class DripFormula {
    fun invoke(volume: Long, hours: Long, useMicroDrips: Boolean): Long {

        var result = (volume / (hours * 3))

        if (useMicroDrips) {
            result *= 3
        }

        return result
    }
}