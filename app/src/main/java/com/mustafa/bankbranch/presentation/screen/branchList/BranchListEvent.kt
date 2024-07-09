package com.mustafa.bankbranch.presentation.screen.branchList

import com.mustafa.bankbranch.data.dto.BranchItem

sealed interface BranchListEvent {
    data object TryAgain : BranchListEvent
    data class SearchBranch(val queryString: String) : BranchListEvent
    data class BranchItemClicked(val branchItem: BranchItem) : BranchListEvent
}