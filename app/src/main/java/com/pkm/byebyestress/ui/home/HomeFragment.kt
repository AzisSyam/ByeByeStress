package com.pkm.byebyestress.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pkm.byebyestress.ViewModelFactory
import com.pkm.byebyestress.databinding.FragmentHomeBinding
import com.pkm.byebyestress.ui.adapter.ActivityAdapter

class HomeFragment : Fragment() {

   private var _binding: FragmentHomeBinding? = null
   private val binding get() = _binding!!

//   private val viewModel: HomeViewModel by viewModels()
   private val viewModel: HomeViewModel by viewModels {
      ViewModelFactory.getInstance(requireContext())
   }

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
//      val homeViewModel =
//         ViewModelProvider(this)[HomeViewModel::class.java]
      _binding = FragmentHomeBinding.inflate(inflater, container, false)
      val root: View = binding.root

      try {
         viewModel.getActivity()
         binding.rvActivity.layoutManager = LinearLayoutManager(requireContext())
         viewModel.userData.observe(viewLifecycleOwner) { activity ->
            val adapter = ActivityAdapter(activity, requireContext())
            adapter.submitList(activity)
            binding.rvActivity.adapter = adapter
         }
      } catch (e:Exception){
         Log.d("Terjadi error viewmodel", "onCreateView: ${e.message}")
      }

      return root
   }

   override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
   }
}