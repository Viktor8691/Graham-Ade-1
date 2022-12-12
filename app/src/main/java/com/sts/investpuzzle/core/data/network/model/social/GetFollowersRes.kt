package com.sts.investpuzzle.core.data.network.model.social

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetFollowersRes (
        @SerializedName("data") val data : GetFollowersResData,
): Parcelable

@Parcelize
data class GetFollowersResData(
        @SerializedName("followers") val followers : List<User>,
        @SerializedName("page") val page : Int,
        @SerializedName("limit") val limit : Int,
        @SerializedName("total") val total : Int,
): Parcelable

