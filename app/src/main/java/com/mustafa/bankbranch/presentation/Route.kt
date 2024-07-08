package com.mustafa.bankbranch.presentation

import com.mustafa.bankbranch.data.dto.BranchItem
import kotlinx.serialization.Serializable

@Serializable
object BranchListScreen

@Serializable
data class BranchDetailScreen(
    val branchItem: BranchItem
)

