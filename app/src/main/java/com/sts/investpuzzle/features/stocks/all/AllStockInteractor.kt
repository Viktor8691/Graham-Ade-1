package com.sts.investpuzzle.features.stocks.all

import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.stock.GetStocksReq
import com.sts.investpuzzle.core.data.network.model.stock.GetStocksRes
import com.sts.investpuzzle.core.data.network.repository.StocksRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject


class AllStockInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val stocksRepository: StocksRepository
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun getStocks(request : GetStocksReq) : Single<GetStocksRes> {
        return stocksRepository.getStocks(request)
    }
}