package com.minthanhtike.vasthivecodetest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.minthanhtike.vasthivecodetest.account.AccountScreen
import com.minthanhtike.vasthivecodetest.discover.DiscoverScreen
import com.minthanhtike.vasthivecodetest.home.HomeScreen
import com.minthanhtike.vasthivecodetest.save.SaveScreen

@Composable
fun BottomNavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(navController = navHostController, startDestination = Screens.Home.route) {

        composable(route = Screens.Home.route) {
            HomeScreen(paddingValues = paddingValues)
        }

        composable(route = Screens.Discover.route) {
            DiscoverScreen(paddingValues = paddingValues)
        }

        composable(route = Screens.Save.route) {
            SaveScreen(paddingValues = paddingValues)
        }

        composable(route = Screens.Account.route) {
            AccountScreen(paddingValues = paddingValues)
        }
    }
}