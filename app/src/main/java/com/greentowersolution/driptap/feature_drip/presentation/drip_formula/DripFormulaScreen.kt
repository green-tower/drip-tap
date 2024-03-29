package com.greentowersolution.driptap.feature_drip.presentation.drip_formula

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.greentowersolution.driptap.composables.LabeledCheckbox
import com.greentowersolution.driptap.feature_drip.domain.use_case.DripFormula

@Composable
fun DripFormula(
    viewModel: DripFormulaViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = viewModel.volume.value,
            onValueChange = { viewModel.volume.value = it },
            label = { Text("Volume") },
            textStyle = TextStyle(
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false
            ),
        )
        TextField(
            value = viewModel.hours.value,
            onValueChange = {
                viewModel.hours.value = it
            },
            label = { Text("Hours") },
            textStyle = TextStyle(
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
            ),

            )
        LabeledCheckbox(
            checked = viewModel.useMicroDrips.value,
            onCheckedChange = {
                viewModel.useMicroDrips.value = it
            },
            text = "Use Micro Drips",
        )
        Button(onClick = {
            if (viewModel.isValid()) {
                viewModel.dripFormula()
            }
        }) {
            Text(
                text = "Calcular formula",
                textAlign = TextAlign.Center
            )
        }
        Text(
            viewModel.resultHowMuchDripsPerMinute.value.toString(),
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
        )
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
fun DripFormulaPreview(){
    Surface {
        DripFormula(viewModel = DripFormulaViewModel(DripFormula()))
    }
}