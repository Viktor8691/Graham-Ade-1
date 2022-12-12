package com.sts.investpuzzle.features.profile.holdings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.portfolio.Holding
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class HoldingScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    holdingScreenInteractor: HoldingScreenInteractor
) : BaseViewModel<HoldingScreenInteractor>(schedulerProvider, compositeDisposable, holdingScreenInteractor){

    private val _holdings = MutableLiveData<Event<List<Holding>>>()
    val holdings : LiveData<Event<List<Holding>>> get() = _holdings

    init {
        getHolding()
    }

    fun getHolding(){
        callInteractor(interactor.getHolding(userDetail!!.id)) {
            _holdings.value = Event(it.holdings)
        }
    }
}