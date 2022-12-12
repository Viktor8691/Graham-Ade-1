package com.sts.investpuzzle.features.profile.myprofile.groups.create_group

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class CreateGroupViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    createGroupInteractor: CreateGroupInteractor
) : BaseViewModel<CreateGroupInteractor>(schedulerProvider, compositeDisposable, createGroupInteractor){

}