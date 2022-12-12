package com.sts.investpuzzle.core.data.network.model.stock

data class GetStocksReq (
    val page : Int = 1,
    val limit : Int = 20,
    val filterType : Int = 0,
    val myfollowonly : Int = 0,
    val keyword : String = ""
)