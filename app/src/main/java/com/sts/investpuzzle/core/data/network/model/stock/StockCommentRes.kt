package com.sts.investpuzzle.core.data.network.model.stock

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockCommentRes(
    @SerializedName("message") val message : String,
): Parcelable
