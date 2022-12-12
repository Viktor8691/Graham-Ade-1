package com.sts.investpuzzle.features.search

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    searchScreenInteractor: SearchScreenInteractor
) : BaseViewModel<SearchScreenInteractor>(schedulerProvider, compositeDisposable, searchScreenInteractor){

}