package com.sts.investpuzzle.features.profile.holdings

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.portfolio.GetHoldingRes
import com.sts.investpuzzle.core.data.network.repository.ProfileRepo
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class HoldingScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val profileRepo: ProfileRepo
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getHolding(userId : String) : Single<GetHoldingRes>{
        return profileRepo.getHolding(userId);
    }
}