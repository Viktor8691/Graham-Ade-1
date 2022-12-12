package com.sts.investpuzzle.core.data.network.repository

import com.google.gson.Gson
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.core.data.network.model.social.*
import com.sts.investpuzzle.core.data.network.model.stock.GetStockCommentRes
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.UserInfoResponse
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

interface SocialRepository {
    fun follow(request : FollowReq, userId : String) : Single<FollowRes>
    fun getFollowers(request : GetFollowersReq, userId: String) : Single<GetFollowersRes>
    fun getFollowings(userId: String) : Single<GetFollowingRes>
    fun acceptFollow(request : AcceptFollowReq, userId : String) : Single<AcceptFollowRes>
}

class SocialRepositoryImp @Inject internal constructor(private val sessionHelper: SessionHelper) : SocialRepository {
    override fun follow(request: FollowReq, userId: String): Single<FollowRes> {
        val jsonString = Gson().toJson(request)
        val jsonObject = JSONObject(jsonString)

        return Rx2AndroidNetworking.post(sessionHelper.apiEndPoint.users + userId + sessionHelper.apiEndPoint.follow)
            .addHeaders(sessionHelper.authToken)
            .addJSONObjectBody(jsonObject)
            .build()
            .getObjectSingle(FollowRes::class.java)
    }

    override fun getFollowers(request : GetFollowersReq, userId: String): Single<GetFollowersRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.users + userId + sessionHelper.apiEndPoint.followers)
            .addHeaders(sessionHelper.authToken)
            .addQueryParameter(request)
            .build()
            .getObjectSingle(GetFollowersRes::class.java)
    }

    override fun getFollowings(userId: String): Single<GetFollowingRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.users + userId + sessionHelper.apiEndPoint.followings)
            .addHeaders(sessionHelper.authToken)
            .build()
            .getObjectSingle(GetFollowingRes::class.java)
    }

    override fun acceptFollow(request: AcceptFollowReq, userId: String): Single<AcceptFollowRes> {
        val jsonString = Gson().toJson(request)
        val jsonObject = JSONObject(jsonString)
        return Rx2AndroidNetworking.post(sessionHelper.apiEndPoint.users + userId + sessionHelper.apiEndPoint.acceptfollow)
            .addHeaders(sessionHelper.authToken)
            .addJSONObjectBody(jsonObject)
            .build()
            .getObjectSingle(AcceptFollowRes::class.java)
    }

}