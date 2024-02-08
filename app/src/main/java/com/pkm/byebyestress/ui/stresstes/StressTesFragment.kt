package com.pkm.byebyestress.ui.stresstes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pkm.byebyestress.databinding.FragmentStressTesBinding
import com.pkm.byebyestress.ui.stresstes.quiz.QuizActivity

class StressTesFragment : Fragment() {

   private var _binding: FragmentStressTesBinding? = null

   // This property is only valid between onCreateView and
   // onDestroyView.
   private val binding get() = _binding!!

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      val stressTesViewModel =
         ViewModelProvider(this).get(StressTesViewModel::class.java)

      _binding = FragmentStressTesBinding.inflate(inflater, container, false)
      val root: View = binding.root
      Log.d("Stress tes fragment", "onCreateView: Ini adalah Stress tes fragment")
      binding.btnStartTest.setOnClickListener {
         val intent = Intent(requireContext(), QuizActivity::class.java)
         startActivity(intent)
      }
      return root
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}