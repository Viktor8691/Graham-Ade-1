package com.sts.investpuzzle.features.profile.myprofile.badge

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class BadgeScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val badgeScreenInteractor: BadgeScreenInteractor
) : BaseViewModel<BadgeScreenInteractor>(schedulerProvider, compositeDisposable, badgeScreenInteractor){

}