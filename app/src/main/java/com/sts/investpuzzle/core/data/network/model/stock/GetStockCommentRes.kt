package com.sts.investpuzzle.core.data.network.model.stock

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetStockCommentRes (
        @SerializedName("data") val data : List<StockComment>,
        @SerializedName("page") val page : Int,
        @SerializedName("limit") val limit : Int,
        @SerializedName("total") val total : Int,
): Parcelable

@Parcelize
data class StockComment(
        @SerializedName("id") val id : String,
        @SerializedName("user") val user : User,
        @SerializedName("content") val content : String,
        @SerializedName("likes") val likes : Int,
        @SerializedName("dislikes") val dislikes : Int,
        @SerializedName("isLiked") val isLiked : Boolean,
        @SerializedName("isDisliked") val isDisliked : Boolean,
): Parcelable