package com.sts.investpuzzle.features.setting

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class SettingScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    settingScreenInteractor: SettingScreenInteractor
) : BaseViewModel<SettingScreenInteractor>(schedulerProvider, compositeDisposable, settingScreenInteractor){

}