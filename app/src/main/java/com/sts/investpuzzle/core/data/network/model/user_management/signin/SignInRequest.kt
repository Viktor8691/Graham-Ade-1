package com.sts.investpuzzle.core.data.network.model.user_management.signin

data class SignInRequest (
        val emailOrUsername : String = "",
        val password : String = "",
        val loginType : Int = 0,
        val socialId : String = "")