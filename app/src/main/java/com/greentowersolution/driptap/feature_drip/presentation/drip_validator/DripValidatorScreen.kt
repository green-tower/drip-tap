package com.greentowersolution.driptap.feature_drip.presentation.drip_validator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun DripValidatorScreen() {

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
                    isCountingDrops = !isCountingDrops
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
            Text(text = "Quantidade de gotas por minuto: 0")
        }
    }
}