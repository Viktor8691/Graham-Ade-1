package com.sts.investpuzzle.core.data.network.model.stock

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TradeStockRes (
    @SerializedName("data") val data : TradeStockResData,
    @SerializedName("message") val message : String,
): Parcelable

@Parcelize
data class TradeStockResData(
    @SerializedName("user") val user : String,
    @SerializedName("stock") val stock : String,
    @SerializedName("amount") val amount : Float,
    @SerializedName("quantity") val quantity : Int,
    @SerializedName("id") val id : String,
): Parcelable