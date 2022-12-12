package com.sts.investpuzzle.features.profile.myprofile.posts

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MyPostViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val myForumScreenInteractor: MyPostInteractor
) : BaseViewModel<MyPostInteractor>(schedulerProvider, compositeDisposable, myForumScreenInteractor){

}