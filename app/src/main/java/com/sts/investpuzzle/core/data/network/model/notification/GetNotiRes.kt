package com.sts.investpuzzle.core.data.network.model.notification

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetNotiRes (
    @SerializedName("data") val data : GetNotiResData,
): Parcelable

@Parcelize
data class GetNotiResData(
    @SerializedName("notifications") val notifications : List<Notification>,
    @SerializedName("page") val page : Int,
    @SerializedName("limit") val limit : Int,
    @SerializedName("total") val total : Int,
): Parcelable

@Parcelize
data class Notification(
    @SerializedName("type") val type : Int,
    @SerializedName("sender") val sender : User,
    @SerializedName("receiver") val receiver : String,
    @SerializedName("linkedId") val linkedId : String,
    @SerializedName("content") val content : String,
    @SerializedName("isRead") val isRead : Int,
    @SerializedName("isAccept") val isAccept : Int,
    @SerializedName("createdAt") val createdAt : String,
    @SerializedName("updatedAt") val updatedAt : String,
    @SerializedName("id") val id : String,
): Parcelable