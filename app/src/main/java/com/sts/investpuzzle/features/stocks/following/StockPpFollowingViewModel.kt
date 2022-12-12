package com.sts.investpuzzle.features.stocks.following

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class StockPpFollowingViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val stockPpFollowingInteractor: StockPpFollowingInteractor
) : BaseViewModel<StockPpFollowingInteractor>(schedulerProvider, compositeDisposable, stockPpFollowingInteractor){

}