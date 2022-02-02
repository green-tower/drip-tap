package com.greentowersolution.driptap.feature_drip.presentation.frequency_settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.greentowersolution.driptap.composables.LabeledCheckbox
import com.greentowersolution.driptap.feature_drip.domain.use_case.ComputeDrips

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

@Preview(
    name = "Light mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
)
@Preview(
    name = "Dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
)
@Composable
fun FrequencySettingsScreenPreview(){
    Surface {
        FrequencySettingsScreen(viewModel = FrequencySettingsViewModel(ComputeDrips()))
    }
}