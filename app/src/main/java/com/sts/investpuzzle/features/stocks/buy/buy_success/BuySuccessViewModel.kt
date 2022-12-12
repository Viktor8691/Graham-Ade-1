package com.sts.investpuzzle.features.stocks.buy.buy_success

import androidx.lifecycle.SavedStateHandle
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.core.data.network.model.stock.TradeStockRes
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class BuySuccessViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val buySuccessInteractor: BuySuccessInteractor,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<BuySuccessInteractor>(schedulerProvider, compositeDisposable, buySuccessInteractor){

    val stockDetail : Stock = savedStateHandle.get<Stock>(BuySuccessScreen.STOCK_DETAIL_ARG)!!
    val buyStockRes : TradeStockRes = savedStateHandle.get<TradeStockRes>(BuySuccessScreen.BUY_STOCK_RESPONSE_ARG)!!
}