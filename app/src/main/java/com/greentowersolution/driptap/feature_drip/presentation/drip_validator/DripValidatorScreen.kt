package com.greentowersolution.driptap.feature_drip.presentation.drip_validator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DripValidatorScreen() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "00:00:00")
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
            onClick = {

            }) {
            Icon(Icons.Filled.PlayArrow, contentDescription = null)
        }

        Card {
            Text(text = "Quantidade de gotas por minuto: 0")
        }
    }
}