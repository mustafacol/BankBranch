package com.mustafa.bankbranch.domain.repository

import com.mustafa.bankbranch.data.dto.BranchItem

interface BankBranchRepository {
    suspend fun getBankBranchData(): List<BranchItem>
}