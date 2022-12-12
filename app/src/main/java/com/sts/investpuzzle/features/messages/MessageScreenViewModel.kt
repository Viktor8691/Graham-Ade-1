package com.sts.investpuzzle.features.messages

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MessageScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    messageScreenInteractor: MessageScreenInteractor
) : BaseViewModel<MessageScreenInteractor>(schedulerProvider, compositeDisposable, messageScreenInteractor){
}