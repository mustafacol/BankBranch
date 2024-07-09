package com.mustafa.bankbranch.data.remote

import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.repository.BankBranchRepository
import retrofit2.Response

class BankBranchRepositoryImpl(
    private val api: BankBranchApi
) : BankBranchRepository {
    override suspend fun getBankBranchData(): Response<List<BranchItem>> {
        return api.getBankData()
    }
}