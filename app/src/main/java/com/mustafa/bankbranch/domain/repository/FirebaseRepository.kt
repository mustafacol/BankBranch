package com.mustafa.bankbranch.domain.repository

import com.mustafa.bankbranch.data.dto.BranchItem

interface FirebaseRepository {
    fun logEvent(branchItem: BranchItem)
}