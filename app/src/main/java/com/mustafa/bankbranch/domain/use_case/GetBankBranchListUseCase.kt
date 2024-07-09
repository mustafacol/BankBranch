package com.mustafa.bankbranch.domain.use_case

import com.mustafa.bankbranch.R
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.repository.BankBranchRepository
import com.mustafa.bankbranch.domain.util.NoAvailableDataException
import com.mustafa.bankbranch.domain.util.Resource
import com.mustafa.bankbranch.presentation.components.UiText
import java.net.UnknownHostException

class GetBankBranchListUseCase(
    private val bankBranchRepository: BankBranchRepository
) {
    suspend operator fun invoke(): Resource<List<BranchItem>> {
        try {
            val response = bankBranchRepository.getBankBranchData()
            if (!response.isSuccessful) {
                throw UnknownError("Something went wrong")
            }
            if (response.body() == null) {
                throw UnknownError("Something went wrong")
            }
            response.body()!!.let { safeBody ->
                if (safeBody.isEmpty()) {
                    throw NoAvailableDataException()
                }
                return Resource.Success(safeBody)
            }
        } catch (unknownError: UnknownError) {
            return Resource.Error(UiText.DynamicString(unknownError.message ?: ""))
        } catch (e: NoAvailableDataException) {
            return Resource.Error(UiText.StringResource(R.string.error_empty_list))
        } catch (e: UnknownHostException) {
            return Resource.Error(UiText.StringResource(R.string.please_check_connection))
        } catch (e: Exception) {
            return Resource.Error(UiText.StringResource(R.string.error_unknown))
        }

    }
}