package com.example.techexactly.data

import com.google.gson.annotations.SerializedName

data class Application(
    @SerializedName("app_id") val appId: Int,
    @SerializedName("fk_kid_id") val fkKidId: Int,
    @SerializedName("kid_profile_image") val kidProfileImage: String,
    @SerializedName("app_name") val appName: String,
    @SerializedName("app_icon") val appIcon: String,
    @SerializedName("app_package_name") val appPackageName: String,
    @SerializedName("status") val status: String,
    var switch: Boolean = false
)