package com.sts.investpuzzle.core.data.network.model.user_management.signin

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignInResponse (
    @SerializedName("data") val data: SignInData,
): Parcelable

@Parcelize
data class SignInData(
    @SerializedName("user") val user : User
): Parcelable