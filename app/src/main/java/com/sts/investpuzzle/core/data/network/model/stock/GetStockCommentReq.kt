package com.sts.investpuzzle.core.data.network.model.stock

data class GetStockCommentReq (
    val page : Int = 1,
    val limit : Int = 20,
    val skip : Int = 0
)