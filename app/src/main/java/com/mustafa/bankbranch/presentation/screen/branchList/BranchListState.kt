package com.mustafa.bankbranch.presentation.screen.branchList

import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.components.UiText

data class BranchListState(
    val branchList: List<BranchItem> = mutableListOf(),
    val queryString: String = "",
    val isSearching: Boolean = false,
    val isLoading: Boolean = false,
    val error: UiText? = null
)

