package com.sts.investpuzzle.features.user_management.start

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.accessories.AccessoriesResponse
import com.sts.investpuzzle.core.data.network.model.user_management.signin.SignInRequest
import com.sts.investpuzzle.core.data.network.model.user_management.signin.SignInResponse
import com.sts.investpuzzle.core.data.network.repository.AccessoriesRepository
import com.sts.investpuzzle.core.data.network.repository.AuthRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject


class StartupScreenInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val accessoriesRepository: AccessoriesRepository,
    private val authRepository: AuthRepository

) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getAccessories() : Single<AccessoriesResponse> {
        return accessoriesRepository.getAccessories()
    }

    fun doSignIn(signInRequest: SignInRequest) : Single<SignInResponse>{
        return authRepository.signIn(signInRequest)
    }

}