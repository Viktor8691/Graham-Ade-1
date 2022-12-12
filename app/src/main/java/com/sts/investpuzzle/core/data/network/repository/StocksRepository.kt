package com.sts.investpuzzle.core.data.network.repository

import com.google.gson.Gson
import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sts.investpuzzle.core.data.network.model.stock.*
import com.sts.investpuzzle.core.data.session.SessionHelper
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

interface StocksRepository {
    fun getStocks(request : GetStocksReq) : Single<GetStocksRes>
    fun tradeStock(request : TradeStockReq) : Single<TradeStockRes>
    fun putComment(request: StockCommentReq, stockId : String) : Single<StockCommentRes>
    fun getComment(request: GetStockCommentReq, stockId : String) : Single<GetStockCommentRes>
}

class StocksRepositoryImp @Inject
internal  constructor(private val sessionHelper: SessionHelper) : StocksRepository {
    override fun getStocks(request: GetStocksReq): Single<GetStocksRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.getStocks)
            .addHeaders(sessionHelper.authToken)
            .addQueryParameter(request)
            .build()
            .getObjectSingle(GetStocksRes::class.java)
    }

    override fun tradeStock(request: TradeStockReq): Single<TradeStockRes> {
        val jsonString = Gson().toJson(request)
        val jsonObject = JSONObject(jsonString)
        return Rx2AndroidNetworking.post(sessionHelper.apiEndPoint.trades)
            .addHeaders(sessionHelper.authToken)
            .addJSONObjectBody(jsonObject)
            .build()
            .getObjectSingle(TradeStockRes::class.java)
    }

    override fun putComment(request: StockCommentReq, stockId : String): Single<StockCommentRes> {
        val jsonString = Gson().toJson(request)
        val jsonObject = JSONObject(jsonString)
        return Rx2AndroidNetworking.post(sessionHelper.apiEndPoint.stocks + stockId + sessionHelper.apiEndPoint.comment)
            .addHeaders(sessionHelper.authToken)
            .addJSONObjectBody(jsonObject)
            .build()
            .getObjectSingle(StockCommentRes::class.java)
    }

    override fun getComment(request: GetStockCommentReq, stockId : String): Single<GetStockCommentRes> {
        return Rx2AndroidNetworking.get(sessionHelper.apiEndPoint.stocks + stockId + sessionHelper.apiEndPoint.comments)
            .addHeaders(sessionHelper.authToken)
            .addQueryParameter(request)
            .build()
            .getObjectSingle(GetStockCommentRes::class.java)
    }
}