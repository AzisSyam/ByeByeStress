package com.pkm.byebyestress.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "dasdasd")

class UserPreferences private constructor(private val datastore: DataStore<Preferences>){

   suspend fun saveSession(user: LoginResult) {
      datastore.edit { preferences ->
         preferences[USER_ID] = user.userId.toString()
         preferences[EMAIL_KEY] = user.userEmail.toString()
      }
   }

   fun getUserSession(): Flow<LoginResult> {
      return datastore.data.map { preferences ->
         LoginResult(
            preferences[USER_ID] ?: "",
            preferences[EMAIL_KEY] ?: ""
         )
      }
   }

   suspend fun logout() {
      datastore.edit { preferences ->
         preferences.clear()
      }
   }

   companion object {
      @Volatile
      private var INSTANCE: UserPreferences? = null

      private val USER_ID = stringPreferencesKey("uid")
      private val EMAIL_KEY = stringPreferencesKey("email")

      fun getInstance(dataStore: DataStore<androidx.datastore.preferences.core.Preferences>): UserPreferences {
         return INSTANCE ?: synchronized(this) {
            val instance = UserPreferences(dataStore)
            INSTANCE = instance
            instance
         }
      }
   }
   
}