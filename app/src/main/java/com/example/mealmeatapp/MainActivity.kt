package com.example.mealmeatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealmateapp.ui.theme.view.HomeScreen
import com.example.mealmeatapp.controller.AuthViewModel
import com.example.mealmeatapp.ui.theme.controller.HomeViewModel
import com.example.mealmeatapp.ui.theme.MealtimeAppTheme
import com.example.mealmeatapp.ui.theme.view.FoodDetailScreen
import com.example.mealmeatapp.ui.theme.view.ForgotPasswordScreen
import com.example.mealmeatapp.ui.theme.view.MealtimeScreen
import com.example.mealmeatapp.ui.theme.view.SignInScreen
import com.example.mealmeatapp.ui.theme.view.SignUpScreen

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealtimeAppTheme {
                val navController = rememberNavController()
                MainScreen(navController, authViewModel, homeViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel
) {
    Scaffold { innerPadding ->
        AppNavigation(
            navController = navController,
            authViewModel = authViewModel,
            homeViewModel = homeViewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navController, startDestination = "mealtime", modifier = modifier) {
        composable("mealtime") {
            MealtimeScreen(
                onSignUpClick = { navController.navigate("signup") },
                onSignInClick = { navController.navigate("signin") }
            )
        }
        composable("signup") {
            SignUpScreen(
                viewModel = authViewModel,
                navController = navController,
                onSignUpSuccess = {
                    navController.navigate("signin") {
                        popUpTo("signup") { inclusive = true }
                    }
                }
            )
        }
        composable("signin") {
            SignInScreen(
                viewModel = authViewModel,
                navController = navController,
                onForgotPasswordClick = { navController.navigate("forgotpassword") }
            )
        }
        composable("forgotpassword") {
            ForgotPasswordScreen(
                viewModel = authViewModel,
                navController = navController
            )
        }
        composable("home") {
            HomeScreen(viewModel = homeViewModel, navController = navController)
        }
        composable(
            route = "foodDetail/{mealId}",
            arguments = listOf(
                navArgument("mealId") { type = androidx.navigation.NavType.IntType }
            )
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getInt("mealId") ?: 0
            FoodDetailScreen(
                navController = navController,
                mealId = mealId
            )
        }
    }
}