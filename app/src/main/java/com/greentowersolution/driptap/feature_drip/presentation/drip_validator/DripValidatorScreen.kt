package com.greentowersolution.driptap.feature_drip.presentation.drip_validator

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DripValidatorScreen(
    dripValidatorViewModel: DripValidatorViewModel
) {

    var isCountingDrops by remember {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "00:00:00")
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = if (isCountingDrops) 0.8f else 1f)
                    .padding(horizontal = 12.dp),
                onClick = {
                    if (isCountingDrops) {
                        dripValidatorViewModel.countDrip()
                    }

                    if (!isCountingDrops) {
                        isCountingDrops = true
                        dripValidatorViewModel.resetDripCounter()
                    }
                }) {
                Icon(
                    if (isCountingDrops) Icons.Filled.WaterDrop else Icons.Filled.PlayArrow,
                    contentDescription = null
                )
            }

            if (isCountingDrops) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 1f)
                        .padding(end = 12.dp),
                    onClick = {
                        isCountingDrops = !isCountingDrops
                    }) {
                    Icon(
                        Icons.Filled.Pause,
                        contentDescription = null
                    )
                }
            }
        }
        Card {
            Text(text = "Quantidade de gotas por minuto: ${dripValidatorViewModel.countedDripsPerMinute.value}")
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
fun DripValidatorScreenPreview(){
    Surface {

        DripValidatorScreen(dripValidatorViewModel = DripValidatorViewModel())
    }
}