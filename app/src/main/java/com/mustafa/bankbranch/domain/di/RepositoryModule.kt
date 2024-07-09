package com.mustafa.bankbranch.domain.di

import com.mustafa.bankbranch.data.remote.BankBranchRepositoryImpl
import com.mustafa.bankbranch.data.remote.FirebaseRepositoryImpl
import com.mustafa.bankbranch.domain.repository.BankBranchRepository
import com.mustafa.bankbranch.domain.repository.FirebaseRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<BankBranchRepository> {
        BankBranchRepositoryImpl(get())
    }

    single<FirebaseRepository> { FirebaseRepositoryImpl(get()) }
}