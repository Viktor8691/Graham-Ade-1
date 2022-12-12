package com.sts.investpuzzle.features.user_management.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.user_management.signin.SignInRequest
import com.sts.investpuzzle.core.data.session.SessionHelper
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class StartupScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    interactor: StartupScreenInteractor,
    private val sessionHelper: SessionHelper
) : BaseViewModel<StartupScreenInteractor>(schedulerProvider, compositeDisposable, interactor){

    private val _isSigninSuccess = MutableLiveData<Event<Boolean>>()
    val isSigninSuccess : LiveData<Event<Boolean>> get() = _isSigninSuccess
    private var signInRequest : SignInRequest? = null

    init {
        signInRequest = sessionHelper.getSignInRequest()
        signInStatus =  signInRequest != null

        getAccessories()

        if (signInStatus)
            doSignin()

    }

    fun doSignin(){
        showLoading()
        compositeDisposable.add(interactor.doSignIn(signInRequest!!)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                sessionHelper.setAuthToken(it.data.user.jwt)
                userDetail = it.data.user
                _isSigninSuccess.value = Event(true)
            }, {
                hideLoading()
            }))
    }

    fun getAccessories(){
        showLoading()
        compositeDisposable.add(interactor.getAccessories()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                hideLoading()
                accessoryData = it.data
            }, {
                hideLoading()
            }))
    }
}