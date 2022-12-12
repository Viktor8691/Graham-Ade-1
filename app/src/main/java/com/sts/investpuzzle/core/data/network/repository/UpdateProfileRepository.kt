package com.sts.investpuzzle.core.data.network.repository

import com.google.gson.Gson
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileRequest
import com.sts.investpuzzle.core.data.network.model.user_management.update_profile.UpdateProfileResponse
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

interface UpdateProfileRepository {
    fun updateProfile(updateProfileRequest: UpdateProfileRequest) : Single<UpdateProfileResponse>
}

class UpdateProfileRepositoryImp @Inject
internal constructor(private val sessionHelper: SessionHelper) : UpdateProfileRepository{
    override fun updateProfile(updateProfileRequest: UpdateProfileRequest): Single<UpdateProfileResponse> {
        return Rx2AndroidNetworking.put(sessionHelper.apiEndPoint.updateProfile)
            .addHeaders(sessionHelper.authToken)
            .addBodyParameter(updateProfileRequest)
            .build()
            .getObjectSingle(UpdateProfileResponse::class.java)
    }
}