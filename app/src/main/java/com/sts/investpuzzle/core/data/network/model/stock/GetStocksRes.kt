package com.sts.investpuzzle.core.data.network.model.stock

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetStocksRes (
    @SerializedName("data") val data : List<Stock>,
    @SerializedName("page") val page : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("total") val total : Int,
) : Parcelable

@Parcelize
data class Stock (
    @SerializedName("symbol") val symbol : String,
    @SerializedName("avgVolume") val avgVolume : Int,
    @SerializedName("change") val change : Float,
    @SerializedName("changesPercentage") val changesPercentage : Float,
    @SerializedName("createdAt") val createdAt : String,
    @SerializedName("dayHigh") val dayHigh : Float,
    @SerializedName("dayLow") val dayLow : Float,
    @SerializedName("exchange") val exchange : String,
    @SerializedName("name") val name : String,
    @SerializedName("open") val open : Float,
    @SerializedName("previousClose") val previousClose : Float,
    @SerializedName("price") val price : Float,
    @SerializedName("priceAvg200") val priceAvg200 : Float,
    @SerializedName("priceAvg50") val priceAvg50 : Float,
    @SerializedName("timestamp") val timestamp : String,
    @SerializedName("updatedAt") val updatedAt : String,
    @SerializedName("volume") val volume : Int,
    @SerializedName("yearHigh") val yearHigh : Double,
    @SerializedName("yearLow") val yearLow : Double,
    @SerializedName("ceo") val ceo : String,
    @SerializedName("country") val country : String,
    @SerializedName("description") val description : String?,
    @SerializedName("image") val image : String,
    @SerializedName("ipoDate") val ipoDate : String,
    @SerializedName("mktCap") val mktCap : Long,
    @SerializedName("sector") val sector : String,
    @SerializedName("followed") val followed : Boolean,
    @SerializedName("id") val id : String,
): Parcelable