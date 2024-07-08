package com.mustafa.bankbranch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mustafa.bankbranch.data.dto.BranchItem

@Composable
fun BankBranchApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BranchListScreen) {
        composable<BranchListScreen> {
        }

        composable<BranchDetailScreen> { backStackEntry ->
            val branchDetail = backStackEntry.toRoute<BranchItem>()
        }
    }
}