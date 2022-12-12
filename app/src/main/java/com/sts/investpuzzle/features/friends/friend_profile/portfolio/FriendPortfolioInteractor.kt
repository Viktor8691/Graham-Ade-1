package com.sts.investpuzzle.features.friends.friend_profile.portfolio

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.portfolio.GetReturnRes
import com.sts.investpuzzle.core.data.network.repository.ProfileRepo
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class FriendPortfolioInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val profileRepo: ProfileRepo
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getReturns(ownerId : String) : Single<GetReturnRes> {
        return  profileRepo.getReturns(ownerId)
    }
}