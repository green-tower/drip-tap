package com.greentowersolution.driptap.feature_drip.presentation.util

import androidx.annotation.StringRes
import com.greentowersolution.driptap.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object DripFormula : Screen("drip_formula", R.string.drip_formula)
    object FrequencySettings : Screen("frequency_settings", R.string.frequency_settings)
    object DripValidator : Screen("drip_validator", R.string.drip_validator)
}
