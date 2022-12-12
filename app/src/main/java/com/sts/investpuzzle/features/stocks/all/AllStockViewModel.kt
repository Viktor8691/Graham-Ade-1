package com.sts.investpuzzle.features.stocks.all

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.constants.Common
import com.sts.investpuzzle.constants.SearchPurpose
import com.sts.investpuzzle.core.data.network.model.stock.GetStocksReq
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AllStockViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    allStockInteractor: AllStockInteractor,
) : BaseViewModel<AllStockInteractor> (schedulerProvider, compositeDisposable, allStockInteractor) {

    var page : Int = 0
    var noStockMore = false
    private val _stocks = MutableLiveData<Event<List<Stock>>>()
    val stocks : LiveData<Event<List<Stock>>> get() = _stocks

    val search : LiveData<Event<String>> get() = searchQuery
    var getStockReq = GetStocksReq()
    var isFirstSearch = false

    init {
        getStocks("")
    }

    fun getStocks(query: String){

        if (noStockMore) return

        if(isFirstSearch) page = 0
        page++
        getStockReq = GetStocksReq(page = page, keyword = query)

        if (getStockReq.keyword.isNotEmpty() && Common.searchPurpose != SearchPurpose.STOCK) return

        callInteractor(interactor.getStocks(getStockReq)) {
            _stocks.value = Event(it.data)
            if (it.data.size < 20 ) noStockMore = true
        }
    }
}