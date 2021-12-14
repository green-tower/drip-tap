package com.greentowersolution.driptap.feature_drip.presentation.frequency_settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FrequencySettingsScreen(
    viewModel: FrequencySettingsViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = { viewModel.computeDrips() },
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = viewModel.dripsPerMinute.value.toString() + " GOTAS POR MINUTO",
                textAlign = TextAlign.Center,
            )
        }
    }
}
