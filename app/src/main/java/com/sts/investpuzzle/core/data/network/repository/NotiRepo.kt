package com.sts.investpuzzle.core.data.network.repository

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.core.data.network.model.notification.GetNotiReq
import com.sts.investpuzzle.core.data.network.model.notification.GetNotiRes
import com.sts.investpuzzle.core.data.network.model.social.GetFollowersRes
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

interface NotiRepo {
    fun getNotis(request : GetNotiReq) : Single<GetNotiRes>
}

class NotiRepoImp @Inject internal  constructor(private val sessionHelper: SessionHelper) : NotiRepo {

    override fun getNotis(request: GetNotiReq): Single<GetNotiRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.notifications)
            .addHeaders(sessionHelper.authToken)
            .addQueryParameter(request)
            .build()
            .getObjectSingle(GetNotiRes::class.java)
    }
}