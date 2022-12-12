package com.sts.investpuzzle.core.data.network.model.social

data class GetFollowersReq (
   val page : Int = 0,
   val limit : Int = 20,
   val keyword : String = ""
)