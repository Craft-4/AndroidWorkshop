package com.drei.androidworkshop

import android.app.Application
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class AndroidWorkshopApplication : Application() {

    companion object {

        private lateinit var firebaseAnalytics: FirebaseAnalytics

        fun logEvent(item: String, contentType: String) {

            val bundle = Bundle()
            bundle.apply {
                putString(FirebaseAnalytics.Param.ITEM_ID, item)
                putString(FirebaseAnalytics.Param.ITEM_NAME, item)
                putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
            }

            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)

        }
    }


    override fun onCreate() {
        super.onCreate()
        firebaseAnalytics = Firebase.analytics
    }
}