package com.pkm.byebyestress

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pkm.byebyestress.data.repository.DataRepository
import com.pkm.byebyestress.di.Injection
import com.pkm.byebyestress.ui.home.HomeViewModel

class ViewModelFactory(private val dataRepository: DataRepository) :
   ViewModelProvider.NewInstanceFactory() {
   @Suppress("UNCHECKED_CAST")
   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return when {
         modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
            HomeViewModel(dataRepository) as T
         }

         else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
      }
   }

   companion object {
      @JvmStatic
      fun getInstance(context: Context): ViewModelFactory {
         return ViewModelFactory(
            Injection.provideDataRepository(context),

         )
      }
   }
}