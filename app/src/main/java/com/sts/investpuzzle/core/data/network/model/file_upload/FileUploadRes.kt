package com.sts.investpuzzle.core.data.network.model.file_upload

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FileUploadRes (
        @SerializedName("filename") val filename : String,
        @SerializedName("path") val path : String,
): Parcelable