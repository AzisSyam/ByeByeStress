package com.pkm.byebyestress.remote.response

data class ActivityResponse(

	val aktivitas: List<ActivityItem?>? = null
)

data class ActivityItem(

	val imageUrl: String? = null,

	val id: String? = null,

	val deskripsi: String? = null,

	val title: String? = null
)
