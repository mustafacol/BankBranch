package com.mustafa.bankbranch.presentation.navigation

import com.mustafa.bankbranch.data.dto.BranchItem
import kotlinx.serialization.Serializable

@Serializable
object BranchListScreen

@Serializable
data class BranchDetailScreen(
    private val branchItem: BranchItem
)

