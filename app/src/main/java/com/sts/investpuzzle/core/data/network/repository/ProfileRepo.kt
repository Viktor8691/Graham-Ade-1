package com.sts.investpuzzle.core.data.network.repository

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.core.data.network.model.portfolio.GetHoldingRes
import com.sts.investpuzzle.core.data.network.model.portfolio.GetReturnRes
import com.sts.investpuzzle.core.data.network.model.stock.ReturnGraphRes
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

interface ProfileRepo {
    fun getReturns(ownerId : String) : Single<GetReturnRes>
    fun getHolding(userId : String) : Single<GetHoldingRes>
    fun getReturnGraph (ownerId : String) : Single<ReturnGraphRes>
}

class ProfileRepoImp @Inject internal constructor(private val sessionHelper: SessionHelper) : ProfileRepo {

    override fun getReturns(ownerId: String): Single<GetReturnRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.users + ownerId + sessionHelper.apiEndPoint._return)
            .addHeaders(sessionHelper.authToken)
            .build()
            .getObjectSingle(GetReturnRes::class.java)
    }

    override fun getHolding(userId: String): Single<GetHoldingRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.users + userId + sessionHelper.apiEndPoint.holdings)
            .addHeaders(sessionHelper.authToken)
            .build()
            .getObjectSingle(GetHoldingRes::class.java)
    }

    override fun getReturnGraph(ownerId: String): Single<ReturnGraphRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.users + ownerId + sessionHelper.apiEndPoint.returnGraph)
            .addHeaders(sessionHelper.authToken)
            .build()
            .getObjectSingle(ReturnGraphRes::class.java)
    }
}