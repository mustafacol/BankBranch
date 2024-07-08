package com.mustafa.bankbranch

import android.app.Application
import com.mustafa.bankbranch.data.networkModule
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
            modules(networkModule)
        }
    }
}