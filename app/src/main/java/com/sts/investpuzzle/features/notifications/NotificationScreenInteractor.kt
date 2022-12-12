package com.sts.investpuzzle.features.notifications

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.notification.GetNotiReq
import com.sts.investpuzzle.core.data.network.model.notification.GetNotiRes
import com.sts.investpuzzle.core.data.network.model.social.AcceptFollowReq
import com.sts.investpuzzle.core.data.network.model.social.AcceptFollowRes
import com.sts.investpuzzle.core.data.network.repository.NotiRepo
import com.sts.investpuzzle.core.data.network.repository.SocialRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class NotificationScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val notiRepo: NotiRepo,
    private val socialRepository: SocialRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getNoti(request : GetNotiReq) : Single<GetNotiRes> {
        return notiRepo.getNotis(request)
    }

    fun acceptFollow(request: AcceptFollowReq, userId : String) : Single<AcceptFollowRes> {
        return socialRepository.acceptFollow(request, userId)
    }
}