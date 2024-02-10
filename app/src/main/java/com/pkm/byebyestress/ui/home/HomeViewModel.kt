package com.pkm.byebyestress.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pkm.byebyestress.data.repository.DataRepository
import com.pkm.byebyestress.remote.response.ActivityItem

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {
   private val _activityData = MutableLiveData<List<ActivityItem?>>()
   val userData: LiveData<List<ActivityItem?>> get() = _activityData

   private val _errorResponse = MutableLiveData<String>()
   val errorResponse: LiveData<String> get() = _errorResponse

   fun getActivity(){
      dataRepository.getActivity()
         .observeForever { user ->
            user?.let {
               _activityData.value = it
            } ?: run {
               _errorResponse.value = "Gagal mengambil data"
            }
         }
   }
}