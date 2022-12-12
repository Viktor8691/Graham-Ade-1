package com.sts.investpuzzle.core.data.network.model.portfolio

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetReturnRes (
        @SerializedName("returns") val returns : GetRetrunResData,
): Parcelable

@Parcelize
data class GetRetrunResData(
        @SerializedName("returns") val returns : Float,
        @SerializedName("percents") val percents : Float,
): Parcelable