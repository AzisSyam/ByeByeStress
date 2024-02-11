package com.pkm.byebyestress.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pkm.byebyestress.databinding.ActivityItemBinding
import com.pkm.byebyestress.remote.response.ActivityItem
import com.pkm.byebyestress.ui.activitydetail.ActivityDetailActivity

class ActivityAdapter(
   private val activityList: List<ActivityItem?>?,     private val context: Context
) : ListAdapter<ActivityItem, ActivityAdapter.MyViewHolder>(DIFF_CALLBACK) {
   override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val data = activityList?.get(position)
      if (data != null) {
         holder.bind(data)
         holder.itemView.setOnClickListener {
            val intent = Intent(context, ActivityDetailActivity::class.java)
            intent.putExtra("activityData", data) // using the (String name, Parcelable value) overload!
            context.startActivity(intent)
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