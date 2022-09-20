package com.greentowersolution.driptap.feature_drip.presentation.drip_validator

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.greentowersolution.driptap.composables.CountDownIndicator
import com.greentowersolution.driptap.utils.Utility
import com.greentowersolution.driptap.utils.Utility.formatTime


@Composable
fun DripValidatorScreen(
    viewModel: DripValidatorViewModel
) {
    val time by viewModel.time.observeAsState(Utility.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.00F)
    val isCountingDrops by viewModel.isPlaying.observeAsState(false)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        CountDownIndicator(
            Modifier.padding(top = 50.dp),
            progress = progress,
            time = time,
            size = 250,
            stroke = 12
        )
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
                        viewModel.countDrip()
                    }

                    if (!isCountingDrops) {
                        viewModel.handleCountDownTimer()
                        viewModel.resetDripCounter()
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
                        viewModel.handleCountDownTimer()
                    }) {
                    Icon(
                        Icons.Filled.Pause,
                        contentDescription = null
                    )
                }
            }
        }
        Card {
            Text(text = "Quantidade de gotas por minuto: ${viewModel.countedDripsPerMinute.value}")
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
        DripValidatorScreen(
            viewModel = DripValidatorViewModel()
        )
    }
}