package com.mustafa.bankbranch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.screen.branchDetail.BranchDetailScreen
import com.mustafa.bankbranch.presentation.screen.branchList.BranchListScreen

@Composable
fun BankBranchApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BranchListScreen) {
        composable<BranchListScreen> {
            BranchListScreen(navController)
        }

        composable<BranchItem>{ backStackEntry ->
            val branchDetail = backStackEntry.toRoute<BranchItem>()
            BranchDetailScreen(branchItem = branchDetail)
        }
    }
}