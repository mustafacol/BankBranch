package com.mustafa.bankbranch.presentation.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.screen.branchDetail.DetailScreen
import com.mustafa.bankbranch.presentation.screen.branchList.MainScreen


@Composable
fun BankBranchApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = NavRoute.BranchListScreen.route) {
        composable(route = NavRoute.BranchListScreen.route) {
            MainScreen(
                onItemClick = { branchItem ->
                    navigateToDetails(navController, branchItem)
                })

        }
        composable(
            route = NavRoute.BranchDetailScreen.route
        ) {
            navController.previousBackStackEntry?.savedStateHandle?.get<BranchItem>("branchItem")
                ?.let { branchItem ->
                    DetailScreen(branchItem = branchItem, onNavigateClick = ::navigateToMaps)
                }

        }
    }
}

private fun navigateToDetails(navController: NavController, branchItem: BranchItem) {
    navController.currentBackStackEntry?.savedStateHandle?.set("branchItem", branchItem)
    navController.navigate(
        route = NavRoute.BranchDetailScreen.route
    )
}

private fun navigateToMaps(context: Context, address: String) {
    val url = "http://maps.google.co.in/maps?q=$address"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}