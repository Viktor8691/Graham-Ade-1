package com.sts.investpuzzle.features.profile.myprofile.groups

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class GroupScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val groupScreenInteractor: GroupScreenInteractor
) : BaseViewModel<GroupScreenInteractor>(schedulerProvider, compositeDisposable, groupScreenInteractor){

}