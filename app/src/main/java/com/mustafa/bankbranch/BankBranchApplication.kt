package com.mustafa.bankbranch

import android.app.Application
import com.mustafa.bankbranch.domain.di.networkModule
import com.mustafa.bankbranch.domain.di.repositoryModule
import com.mustafa.bankbranch.domain.di.useCaseModule
import com.mustafa.bankbranch.domain.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BankBranchApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BankBranchApplication)
            androidLogger(Level.DEBUG)
            modules(networkModule, repositoryModule, viewModelModule, useCaseModule)
        }
    }
}