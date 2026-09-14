package com.example.practica01

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practica1.FirstScreen
import com.example.practica1.SecondScreen

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first"
    ) {
        composable("first") {
            FirstScreen(onNavigateToSecondScreen = { texto ->
                navController.navigate("second/$texto")
            })
        }
        composable(
            route = "second/{texto}",
            arguments = listOf(navArgument("texto") { type = NavType.StringType })
        ) { backStackEntry ->
            val texto = backStackEntry.arguments?.getString("texto") ?: ""
            SecondScreen(mensaje = texto)
        }
    }
}