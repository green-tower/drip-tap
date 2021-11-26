package com.greentowersolution.driptap

import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.unit.sp

@Composable
fun DripFormula() {

    var volume by remember { mutableStateOf("") }
    var hours by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Result") }

    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors() else lightColors(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = volume,
                onValueChange = { volume = it },
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
                value = hours,
                onValueChange = { hours = it },
                label = { Text("Label") },
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
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Calcular formula",
                    textAlign = TextAlign.Center
                )
            }
            Text(
                result,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}