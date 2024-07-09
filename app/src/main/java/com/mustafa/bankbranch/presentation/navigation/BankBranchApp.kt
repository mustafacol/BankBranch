package com.mustafa.bankbranch.presentation.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.network_connectivity.ConnectivityObserver
import com.mustafa.bankbranch.presentation.components.AlertDialogComponent
import com.mustafa.bankbranch.presentation.screen.branchDetail.BranchDetailScreen
import com.mustafa.bankbranch.presentation.screen.branchList.MainScreen


@Composable
fun BankBranchApp(connectivityStatus: ConnectivityObserver.Status) {
    val navController = rememberNavController()

    CheckConnection(connectivityStatus = connectivityStatus)

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
                    BranchDetailScreen(
                        branchItem = branchItem,
                        onNavigateBack = { navController.popBackStack() },
                        onNavigateClick = ::navigateToMaps
                    )
                }

        }
    }
}

@Composable
fun CheckConnection(connectivityStatus: ConnectivityObserver.Status) {
    var showConnectivityDialog by remember { mutableStateOf(false) }
    showConnectivityDialog = when (connectivityStatus) {
        ConnectivityObserver.Status.Available -> false
        ConnectivityObserver.Status.Unavailable, ConnectivityObserver.Status.Lost -> true
    }
    if (showConnectivityDialog) {
        AlertDialogComponent()
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

