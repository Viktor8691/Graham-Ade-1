package com.sts.investpuzzle.features.profile.myprofile.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.portfolio.GetRetrunResData
import com.sts.investpuzzle.core.data.network.model.stock.Coordinate
import com.sts.investpuzzle.core.data.network.model.stock.ReturnGraphResData
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class PortfolioScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val portfolioScreenInteractor: PortfolioScreenInteractor
) : BaseViewModel<PortfolioScreenInteractor>(schedulerProvider, compositeDisposable, portfolioScreenInteractor){

    private val _returns = MutableLiveData<Event<GetRetrunResData>>()
    val returns : LiveData<Event<GetRetrunResData>> get() = _returns

    private val _returnGraph = MutableLiveData<Event<ReturnGraphResData>>()
    val returnGraph : LiveData<Event<ReturnGraphResData>> get() = _returnGraph

    init {
        getReturns()
        getReturnGraph()
    }

    private fun getReturns(){
        callInteractor(interactor.getReturns(userDetail!!.id)) {
            _returns.value = Event(it.returns)
        }
    }

    private fun getReturnGraph(){
        callInteractor(interactor.getReturnGraph(userDetail!!.id)){
            _returnGraph.value = Event(it.returns)
        }
    }
}