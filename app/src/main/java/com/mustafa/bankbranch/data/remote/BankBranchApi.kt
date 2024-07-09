package com.mustafa.bankbranch.data.remote

import com.mustafa.bankbranch.data.dto.BranchItem
import retrofit2.Response
import retrofit2.http.GET

interface BankBranchApi {
    @GET("bankdata")
    suspend fun getBankData(): Response<List<BranchItem>>
}