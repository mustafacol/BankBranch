package com.mustafa.bankbranch.domain.use_case

import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.repository.FirebaseRepository

class LogEventUseCase(private val firebaseRepository: FirebaseRepository) {
    operator fun invoke(branchItem: BranchItem) {
        firebaseRepository.logEvent(branchItem)
    }
}