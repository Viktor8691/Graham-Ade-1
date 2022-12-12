package com.sts.investpuzzle.features.stocks.stock_detail

import android.content.SharedPreferences
import com.sts.investpuzzle.base.BaseInteractor
import com.sts.investpuzzle.core.data.network.model.social.FollowReq
import com.sts.investpuzzle.core.data.network.model.social.FollowRes
import com.sts.investpuzzle.core.data.network.model.stock.GetStockCommentReq
import com.sts.investpuzzle.core.data.network.model.stock.GetStockCommentRes
import com.sts.investpuzzle.core.data.network.model.stock.StockCommentReq
import com.sts.investpuzzle.core.data.network.model.stock.StockCommentRes
import com.sts.investpuzzle.core.data.network.repository.SocialRepository
import com.sts.investpuzzle.core.data.network.repository.StocksRepository
import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import javax.inject.Inject

class StockDetailInteractor @Inject internal constructor(
    preferencesHelper: PreferencesHelper,
    sessionHelper: SessionHelper,
    private val stocksRepository: StocksRepository,
) : BaseInteractor(preferencesHelper, sessionHelper){

    fun putComment(request : StockCommentReq, stockId : String) : Single<StockCommentRes> {
        return stocksRepository.putComment(request, stockId)
    }

    fun getComments(request : GetStockCommentReq, stockId: String) : Single<GetStockCommentRes>{
        return stocksRepository.getComment(request, stockId)
    }
}