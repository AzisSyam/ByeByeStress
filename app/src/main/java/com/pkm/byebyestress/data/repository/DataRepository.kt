package com.pkm.byebyestress.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.pkm.byebyestress.remote.response.ActivityItem
import com.pkm.byebyestress.remote.response.ActivityResponse

class DataRepository(private val db: FirebaseFirestore) {


   fun getActivity(): MutableLiveData<List<ActivityItem?>?>{
      val resultLiveData = MutableLiveData<List<ActivityItem?>?>()

      try {
         val docRef = db.collection("aktivitas").document("daftar_aktivitas")
         docRef.get()
            .addOnSuccessListener { document ->
               if (document.exists()) {
                  val user = document.toObject(ActivityResponse::class.java)
                  user?.let {
                     resultLiveData.value = it.aktivitas
                     Log.d("Home", "data: $it")
                  }

               } else {
                  // Handle case when document does not exist
                  Log.d("UserRepository", "No such document")
               }
            }
            .addOnFailureListener { exception ->
               // Handle failure
               Log.d("UserRepository", "get failed with ", exception)
               resultLiveData.value = null

            }
      } catch (e: Exception) {
         // Handle exception
         Log.d("UserRepository", "Exception: ${e.message}")
         resultLiveData.value = null
      }

      return resultLiveData
   }
}