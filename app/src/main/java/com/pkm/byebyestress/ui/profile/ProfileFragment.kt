package com.pkm.byebyestress.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pkm.byebyestress.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {
   // TODO: Rename and change types of parameters
   private var param1: String? = null
   private var param2: String? = null

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

   }

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_profile, container, false)
   }

   companion object {

      // TODO: Rename and change types and number of parameters
      @JvmStatic
      fun newInstance(param1: String, param2: String) =
         ProfileFragment().apply {
            arguments = Bundle().apply {
               putString(ARG_PARAM1, param1)
               putString(ARG_PARAM2, param2)
            }
         }
   }
}