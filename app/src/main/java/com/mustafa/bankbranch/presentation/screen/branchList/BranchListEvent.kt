package com.mustafa.bankbranch.presentation.screen.branchList

import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.presentation.components.UiText

sealed interface BranchListEvent {
    data object TryAgain : BranchListEvent
    data class ShowError(val uiText: UiText) : BranchListEvent
    data class NavigateDetail(val branchItem: BranchItem) : BranchListEvent
    data class SearchBranch(val queryString: String) : BranchListEvent
}