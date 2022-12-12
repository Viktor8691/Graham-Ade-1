package com.sts.investpuzzle.features.main_fragment

import android.util.Log
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@HiltViewModel
class MainScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    mainScreenInteractor: MainScreenInteractor,
) : BaseViewModel<MainScreenInteractor>(schedulerProvider, compositeDisposable, mainScreenInteractor){

    fun search(query : String){
        searchQuery.value = Event(query)
    }
}