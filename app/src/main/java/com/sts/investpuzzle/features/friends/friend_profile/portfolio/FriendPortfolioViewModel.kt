package com.sts.investpuzzle.features.friends.friend_profile.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.portfolio.GetRetrunResData
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class FriendPortfolioViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val portfolioScreenInteractor: FriendPortfolioInteractor
) : BaseViewModel<FriendPortfolioInteractor>(schedulerProvider, compositeDisposable, portfolioScreenInteractor){

    private val _returns = MutableLiveData<Event<GetRetrunResData>>()
    val returns : LiveData<Event<GetRetrunResData>> get() = _returns

    init {
        getReturns()
    }

    fun getReturns(){

    }
}