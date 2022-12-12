package com.sts.investpuzzle.core.data.network.model.notification

data class GetNotiReq (
    val page : Int = 0,
    val limit : Int = 20,
    val keyword : String = "",
    val filterType : Int = -1
)