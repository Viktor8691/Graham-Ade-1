package com.sts.investpuzzle.features.friends.friend_profile

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.social.FollowReq
import com.sts.investpuzzle.core.data.network.model.social.FollowRes
import com.sts.investpuzzle.core.data.network.repository.SocialRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class FriendProfileInteractor @Inject internal  constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val socialRepository: SocialRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun follow(request : FollowReq, userId : String) : Single<FollowRes> {
        return socialRepository.follow(request, userId)
    }
}