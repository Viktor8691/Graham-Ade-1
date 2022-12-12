package com.sts.investpuzzle.features.profile.myprofile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.esafirm.imagepicker.model.Image
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.constants.ACL
import com.sts.investpuzzle.constants.FOLDER
import com.sts.investpuzzle.constants.FileUploadStatus
import com.sts.investpuzzle.core.data.network.ApiEndPoint
import com.sts.investpuzzle.core.data.network.model.file_upload.FileUploadReq
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileRequest
import com.sts.investpuzzle.core.data.session.SessionHelper
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.Utils
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MyProfileScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    myProfileScreenInteractor: MyProfileScreenInteractor,
    val sessionHelper: SessionHelper
)  : BaseViewModel<MyProfileScreenInteractor>(schedulerProvider, compositeDisposable, myProfileScreenInteractor){

    private val _isProfileUpdated = MutableLiveData<Event<Boolean>>()
    val isProfileUpdated : LiveData<Event<Boolean>> get() = _isProfileUpdated

    fun uploadProfilePicture(image : Image){
        val request = FileUploadReq(File(image.path))
        callInteractor(interactor.uploadFile(request)) {
            updateProfile(it.filename)
        }
    }

    private fun updateProfile(fileName : String){
        val updateProfileRequest = UpdateProfileRequest(photoUrl = sessionHelper.apiEndPoint.BASE_URL + fileName)
        callInteractor(interactor.updateProfile(updateProfileRequest)) {
            userDetail = it.data.user
        }
    }
}