package com.sts.investpuzzle.core.data.network.model.stock

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReturnGraphRes (
    @SerializedName("returns") val returns : ReturnGraphResData,
): Parcelable

@Parcelize
data class ReturnGraphResData(
    @SerializedName("1D") val d1 : List<Coordinate>,
    @SerializedName("1W") val w1 : List<Coordinate>,
    @SerializedName("1M") val m1 : List<Coordinate>,
    @SerializedName("3M") val m3 : List<Coordinate>,
    @SerializedName("6M") val m6 : List<Coordinate>,
    @SerializedName("1Y") val y1 : List<Coordinate>,
    @SerializedName("All") val all : List<Coordinate>,
): Parcelable

@Parcelize
data class Coordinate(
    @SerializedName("id") val id : String,
    @SerializedName("message") val user : String,
    @SerializedName("returns") val returns : Float,
    @SerializedName("percents") val percents : Float,
    @SerializedName("createdAt") val createdAt : Long,
    @SerializedName("updatedAt") val updatedAt : String,
): Parcelable