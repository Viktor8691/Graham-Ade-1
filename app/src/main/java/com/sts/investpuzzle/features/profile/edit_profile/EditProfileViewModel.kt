package com.sts.investpuzzle.features.profile.edit_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileRequest
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val editProfileInteractor: EditProfileInteractor
) : BaseViewModel<EditProfileInteractor>(schedulerProvider, compositeDisposable, editProfileInteractor) {

    private val _isProfileUpdated = MutableLiveData<Event<Boolean>>()
    val isProfileUpdated : LiveData<Event<Boolean>> get() = _isProfileUpdated

    fun editProfile(name : String, bio: String){
        val request = UpdateProfileRequest(userFullName = name, bio = bio)
        callInteractor(interactor.updateProfile(request)){
            userDetail = it.data.user
            _isProfileUpdated.value = Event(true)
        }
    }
}