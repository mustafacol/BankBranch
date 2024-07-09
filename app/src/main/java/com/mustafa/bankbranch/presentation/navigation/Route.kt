package com.mustafa.bankbranch.presentation.navigation


sealed class NavRoute(
    val route: String,
) {
    data object BranchListScreen : NavRoute(route = "branchListScreen")
    data object BranchDetailScreen : NavRoute(route = "branchDetailScreen")
}
