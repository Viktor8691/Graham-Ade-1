package com.sts.investpuzzle.core.data.network.model.stock

data class TradeStockReq (
    val stock : String,
    val amount : Float,
    val quantity : Int,
    val isBuy : Int)   // isBuy = 1 : buy , 0 : sell