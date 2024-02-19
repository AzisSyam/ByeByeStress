package com.pkm.byebyestress.di

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import com.pkm.byebyestress.data.pref.UserPreferences
import com.pkm.byebyestress.data.pref.dataStore
import com.pkm.byebyestress.data.repository.DataRepository
import com.pkm.byebyestress.data.repository.UserRepository

object Injection {

   fun provideDataRepository(context: Context): DataRepository {
      val db = Firebase.firestore
      return DataRepository(db)
   }

   fun provideUserRepository(context: Context): UserRepository {
      val firebaseAuth = FirebaseAuth.getInstance()
      val pref = UserPreferences.getInstance(context.dataStore)
      return UserRepository(pref, firebaseAuth, context)
   }

}