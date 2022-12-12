package com.sts.investpuzzle.features.stocks.buy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.core.data.network.model.stock.TradeStockReq
import com.sts.investpuzzle.core.data.network.model.stock.TradeStockRes
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class BuyStockViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    buyStockInteractor: BuyStockInteractor,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<BuyStockInteractor>(schedulerProvider, compositeDisposable, buyStockInteractor){

    val stockDetail by lazy {
        savedStateHandle.get<Stock>(BuyStockScreen.STOCK_DETAIL_SCREEN_ARG)
    }

    var quantity : Int = 0

    private val _purchaseSuccess = MutableLiveData<Event<Boolean>> ()
    val purchaseSuccess : LiveData<Event<Boolean>> get() = _purchaseSuccess

    var tradeStockRes : TradeStockRes? = null

    fun buyStock(){
        if (quantity == 0) {
            showError("Quantity Error", "Please input the amount that you want to buy")
            return
        }
        val amount = stockDetail!!.price * quantity
        val request = TradeStockReq(stockDetail!!.id, amount, quantity, 1)
        callInteractor(interactor.buyStock(request)) {
            tradeStockRes = it
            _purchaseSuccess.value = Event(true)
        }
    }
}