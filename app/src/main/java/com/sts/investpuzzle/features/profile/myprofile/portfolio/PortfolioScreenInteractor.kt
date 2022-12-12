package com.sts.investpuzzle.features.profile.myprofile.portfolio

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.portfolio.GetReturnRes
import com.sts.investpuzzle.core.data.network.model.stock.ReturnGraphRes
import com.sts.investpuzzle.core.data.network.repository.ProfileRepo
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class PortfolioScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val profileRepo: ProfileRepo,
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getReturns(ownerId : String) : Single<GetReturnRes> {
        return  profileRepo.getReturns(ownerId)
    }

    fun getReturnGraph(ownerId: String) : Single<ReturnGraphRes>{
        return profileRepo.getReturnGraph(ownerId)
    }
}