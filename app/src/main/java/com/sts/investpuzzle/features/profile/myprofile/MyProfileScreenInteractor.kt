package com.sts.investpuzzle.features.profile.myprofile

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.constants.FileUploadStatus
import com.sts.investpuzzle.core.data.network.model.file_upload.FileUploadReq
import com.sts.investpuzzle.core.data.network.model.file_upload.FileUploadRes
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileRequest
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileResponse
import com.sts.investpuzzle.core.data.network.repository.FileUploadRepo
import com.sts.investpuzzle.core.data.network.repository.UpdateProfileRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class MyProfileScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val fileUploadRepo: FileUploadRepo,
    private val updateProfileRepository: UpdateProfileRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun uploadFile(request : FileUploadReq) : Single<FileUploadRes> {
        return fileUploadRepo.fileUpload(request)
    }

    fun updateProfile(request: UpdateProfileRequest) : Single<UpdateProfileResponse>{
        return updateProfileRepository.updateProfile(request)
    }
}