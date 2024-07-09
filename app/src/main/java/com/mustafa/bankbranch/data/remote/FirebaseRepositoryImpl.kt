package com.mustafa.bankbranch.data.remote

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
import com.mustafa.bankbranch.data.dto.BranchItem
import com.mustafa.bankbranch.domain.repository.FirebaseRepository

class FirebaseRepositoryImpl(private val firebaseAnalytics: FirebaseAnalytics) :
    FirebaseRepository {
    override fun logEvent(branchItem: BranchItem) {
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.ITEM_ID, branchItem.id.toString())
            param(FirebaseAnalytics.Param.ITEM_NAME, branchItem.addressName)
        }
    }
}