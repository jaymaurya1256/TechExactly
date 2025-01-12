package com.example.techexactly.data

import com.google.gson.annotations.SerializedName

data class ApplicationResponseWrapper(
    val success: Boolean,
    val data: ApplicationResponseAppList
)

data class ApplicationResponseAppList(
    @SerializedName("app_list") val appList: List<Application>
)
