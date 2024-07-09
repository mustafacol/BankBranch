package com.mustafa.bankbranch.domain.di

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val firebaseModule = module {
    single { provideFirebaseAnalytics(androidContext()) }
}

fun provideFirebaseAnalytics(context: Context): FirebaseAnalytics {
    return FirebaseAnalytics.getInstance(context)
}
