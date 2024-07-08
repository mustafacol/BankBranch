package com.mustafa.bankbranch.data.remote

import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.repository.BankBranchRepository

class BankBranchRepositoryImpl(
    private val api: BankBranchApi
) : BankBranchRepository {
    override suspend fun getBankBranchData(): List<BranchItem> {
        return api.getBankData()
    }
}