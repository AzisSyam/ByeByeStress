package com.pkm.byebyestress.di

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.pkm.byebyestress.data.repository.DataRepository

object Injection {

   fun provideDataRepository(context: Context): DataRepository {
      val db = Firebase.firestore
      return DataRepository(db)
   }
}