package com.mustafa.bankbranch.domain.repository

import com.mustafa.bankbranch.data.dto.BranchItem
import retrofit2.Response

interface BankBranchRepository {
    suspend fun getBankBranchData(): Response<List<BranchItem>>
}