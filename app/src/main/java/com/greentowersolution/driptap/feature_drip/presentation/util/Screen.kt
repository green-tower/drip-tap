package com.greentowersolution.driptap.feature_drip.presentation.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.ui.graphics.vector.ImageVector
import com.greentowersolution.driptap.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object DripFormula : Screen(
        route = "drip_formula",
        resourceId = R.string.drip_formula,
        icon = Icons.Filled.WaterDrop,
    )
    object FrequencySettings : Screen(
        route = "frequency_settings",
        resourceId = R.string.frequency_settings,
        icon = Icons.Filled.Settings,
    )
    object DripValidator : Screen(
        route = "drip_validator",
        resourceId = R.string.drip_validator,
        icon = Icons.Filled.Check,
    )
}
