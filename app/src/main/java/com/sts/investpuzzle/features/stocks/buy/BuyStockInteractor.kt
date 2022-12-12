package com.sts.investpuzzle.features.stocks.buy

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.stock.TradeStockReq
import com.sts.investpuzzle.core.data.network.model.stock.TradeStockRes
import com.sts.investpuzzle.core.data.network.repository.StocksRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class BuyStockInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val stocksRepository: StocksRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun buyStock(request : TradeStockReq) : Single<TradeStockRes>{
        return stocksRepository.tradeStock(request)
    }
}