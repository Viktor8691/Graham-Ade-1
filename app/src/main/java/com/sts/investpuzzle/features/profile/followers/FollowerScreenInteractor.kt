package com.sts.investpuzzle.features.profile.followers

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.social.GetFollowersReq
import com.sts.investpuzzle.core.data.network.model.social.GetFollowersRes
import com.sts.investpuzzle.core.data.network.repository.SocialRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class FollowerScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val socialRepository: SocialRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getFollowers(request : GetFollowersReq, userId : String) : Single<GetFollowersRes> {
        return  socialRepository.getFollowers(request, userId)
    }
}