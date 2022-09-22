package com.greentowersolution.driptap.feature_drip.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.greentowersolution.driptap.composables.CountDownIndicatorViewModel
import com.greentowersolution.driptap.feature_drip.presentation.drip_formula.DripFormula
import com.greentowersolution.driptap.feature_drip.presentation.drip_formula.DripFormulaViewModel
import com.greentowersolution.driptap.feature_drip.presentation.drip_validator.DripValidatorScreen
import com.greentowersolution.driptap.feature_drip.presentation.drip_validator.DripValidatorViewModel
import com.greentowersolution.driptap.feature_drip.presentation.frequency_settings.FrequencySettingsScreen
import com.greentowersolution.driptap.feature_drip.presentation.frequency_settings.FrequencySettingsViewModel
import com.greentowersolution.driptap.feature_drip.presentation.util.Screen
import com.greentowersolution.driptap.ui.theme.DripTapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DripTapTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val bottomNavigationItems = listOf(
        Screen.DripFormula,
        Screen.FrequencySettings,
        Screen.DripValidator
    )

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.DripFormula.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.DripFormula.route) {
                val viewModel = viewModel<DripFormulaViewModel>()
                DripFormula(viewModel)
            }
            composable(Screen.FrequencySettings.route) {
                val viewModel = viewModel<FrequencySettingsViewModel>()
                FrequencySettingsScreen(viewModel)
            }
            composable(Screen.DripValidator.route) {
                val viewModel = viewModel<DripValidatorViewModel>()
                val countDownViewModel = viewModel<CountDownIndicatorViewModel>()
                DripValidatorScreen(viewModel, countDownViewModel)
            }
        }
    }
}

@Composable
private fun AppBottomNavigation(
    navController: NavHostController,
    items: List<Screen>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
