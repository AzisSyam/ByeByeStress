package com.pkm.byebyestress.ui.activitydetail

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pkm.byebyestress.databinding.ActivityDetailBinding
import com.pkm.byebyestress.remote.response.ActivityItem

class ActivityDetailActivity : AppCompatActivity() {
   private var _binding: ActivityDetailBinding? = null
   private val binding get() = _binding!!

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      _binding = ActivityDetailBinding.inflate(layoutInflater)
      setContentView(binding.root)

      binding.topAppBar.setNavigationOnClickListener {
         onBackPressed()
      }

      val activityData = intent.getParcelableExtra<ActivityItem>("activityData")
      if (activityData != null) {
         Log.d("detail aktivitas", "onCreate: $activityData")

         binding.apply {
            Glide.with(activityImage)
               .load(activityData.imageUrl)
               .into(activityImage)
            activityTitle.text = activityData.title
            descriptionActivity.text = activityData.deskripsi
         }
      } else {
         Log.d("detail aktivitas", "onCreate: tidak ada data")
      }
   }
}