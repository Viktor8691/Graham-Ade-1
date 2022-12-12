package com.sts.investpuzzle.core.data.network.repository

import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.constants.FileUploadStatus
import com.sts.investpuzzle.core.data.network.model.file_upload.FileUploadReq
import com.sts.investpuzzle.core.data.network.model.file_upload.FileUploadRes
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

interface FileUploadRepo {
    fun fileUpload(request : FileUploadReq) : Single<FileUploadRes>
}

class FileUploadRepoImp @Inject
internal constructor(private val sessionHelper: SessionHelper) : FileUploadRepo {
    override fun fileUpload(request: FileUploadReq) : Single<FileUploadRes> {
        return Rx2AndroidNetworking.upload(sessionHelper.apiEndPoint.uploadFile)
            .addMultipartFile("file", request.file)
            .setPriority(Priority.HIGH)
            .build()
            .getObjectSingle(FileUploadRes::class.java)
    }
}