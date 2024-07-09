package com.mustafa.bankbranch.domain.di

import com.mustafa.bankbranch.presentation.screen.branchList.BranchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BranchListViewModel(get(),get())
    }
}