package com.sts.investpuzzle.core.data.network.model.user_management.update_profile

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateProfileResponse (
    @SerializedName("data") val data : UpdateProfileData,
) : Parcelable

@Parcelize
data class UpdateProfileData(
    @SerializedName("user") val user : User,
) : Parcelable