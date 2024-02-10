package com.pkm.byebyestress.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.pkm.byebyestress.databinding.ActivityItemBinding
import com.pkm.byebyestress.remote.response.ActivityItem

class ActivityAdapter(
   private val activityList: List<ActivityItem?>?,
) : ListAdapter<ActivityItem, ActivityAdapter.MyViewHolder>(DIFF_CALLBACK) {
   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val data = activityList?.get(position)
      if (data != null) {
         holder.bind(data)
         holder.itemView.setOnClickListener {

         }
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding =
         ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return MyViewHolder(binding)
   }

   class MyViewHolder(private val binding: ActivityItemBinding) :
      RecyclerView.ViewHolder(binding.root) {
      fun bind(data: ActivityItem) {
         binding.apply {
            tvTitleActivity.text = data.title
            Glide.with(imageActivity)
               .load(data.imageUrl)
               .transform(RoundedCorners(20))
               .into(binding.imageActivity)
         }
      }
   }

   companion object {
      private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ActivityItem>() {
         override fun areItemsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean {
            return oldItem == newItem
         }

         override fun areContentsTheSame(oldItem: ActivityItem, newItem: ActivityItem): Boolean {
            return oldItem == newItem
         }
      }
   }
}