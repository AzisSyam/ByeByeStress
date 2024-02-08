package com.pkm.byebyestress.ui.stresstes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StressTesViewModel : ViewModel() {

   private val _text = MutableLiveData<String>().apply {
      value = "This is dashboard Fragment"
   }
   val text: LiveData<String> = _text
}