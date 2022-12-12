package com.sts.investpuzzle.features.profile.following

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.social.GetFollowingRes
import com.sts.investpuzzle.core.data.network.repository.SocialRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class FollowingScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val socialRepository: SocialRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getFollowings(userId : String) : Single<GetFollowingRes> {
        return socialRepository.getFollowings(userId)
    }
}