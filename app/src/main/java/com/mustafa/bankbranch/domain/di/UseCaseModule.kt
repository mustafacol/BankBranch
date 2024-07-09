package com.mustafa.bankbranch.domain.di

import com.mustafa.bankbranch.domain.use_case.GetBankBranchListUseCase
import com.mustafa.bankbranch.domain.use_case.LogEventUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetBankBranchListUseCase> {
        GetBankBranchListUseCase(get())
    }
    factory<LogEventUseCase> { LogEventUseCase(get()) }
}