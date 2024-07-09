package com.mustafa.bankbranch.domain.di

import com.mustafa.bankbranch.domain.use_case.GetBankBranchListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetBankBranchListUseCase> {
        GetBankBranchListUseCase(get())
    }
}