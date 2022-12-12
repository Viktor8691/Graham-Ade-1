package com.sts.investpuzzle.features.profile.myprofile.groups.add_participants

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AddParticipantViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val addParticipantInteractor: AddParticipantInteractor
) : BaseViewModel<AddParticipantInteractor>(schedulerProvider, compositeDisposable, addParticipantInteractor){

}