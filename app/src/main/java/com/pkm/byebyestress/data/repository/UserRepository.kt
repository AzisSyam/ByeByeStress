package com.pkm.byebyestress.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.pkm.byebyestress.data.pref.UserPreferences

class UserRepository(
   private val userPreferences: UserPreferences,
   private val firebaseAuth: FirebaseAuth,
   private val context: android.content.Context
) {
   fun signInWithEmailAndPassword(email: String, password: String): Task<AuthResult> {
      return firebaseAuth.signInWithEmailAndPassword(email, password)
   }
}