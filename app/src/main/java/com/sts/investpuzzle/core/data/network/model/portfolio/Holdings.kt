package com.sts.investpuzzle.core.data.network.model.portfolio

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import kotlinx.parcelize.Parcelize

data class GetHoldingRes (
        @SerializedName("holdings") val holdings : List<Holding>,
)

@Parcelize
data class Holding (
        @SerializedName("id") val id : String,
        @SerializedName("total") val total : Float,
        @SerializedName("percent") val percent : Float,
        @SerializedName("stock") val stock : Stock,
): Parcelable