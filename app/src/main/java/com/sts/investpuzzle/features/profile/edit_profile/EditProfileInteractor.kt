package com.sts.investpuzzle.features.profile.edit_profile

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileRequest
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileResponse
import com.sts.investpuzzle.core.data.network.repository.UpdateProfileRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class EditProfileInteractor @Inject internal  constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val updateProfileRepository: UpdateProfileRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun updateProfile(request : UpdateProfileRequest) : Single<UpdateProfileResponse> {
        return updateProfileRepository.updateProfile(request)
    }
}