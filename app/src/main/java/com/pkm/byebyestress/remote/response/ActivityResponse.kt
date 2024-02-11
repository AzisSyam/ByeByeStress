package com.pkm.byebyestress.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ActivityResponse(

   val aktivitas: List<ActivityItem?>? = null
)

@Parcelize
data class ActivityItem(

   val imageUrl: String? = null,

   val id: String? = null,

   val deskripsi: String? = null,

   val title: String? = null
) : Parcelable
