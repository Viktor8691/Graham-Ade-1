package com.sts.investpuzzle.features.stocks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.stock.GetStocksReq
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class StockScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val stockScreenInteractor: StockScreenInteractor
) : BaseViewModel<StockScreenInteractor>(schedulerProvider, compositeDisposable, stockScreenInteractor){
}