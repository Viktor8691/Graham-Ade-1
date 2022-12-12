package com.sts.investpuzzle.core.data.network.model.social

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FollowRes (
    @SerializedName("message") val message : String,
) : Parcelable