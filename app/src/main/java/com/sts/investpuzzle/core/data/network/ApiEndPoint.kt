package com.sts.investpuzzle.core.data.network

import com.sts.investpuzzle.core.data.prefs.PreferencesHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiEndPoint @Inject constructor(private val preferencesHelper: PreferencesHelper) {
    val BASE_URL = "https://wafflestock.com/"
    val signInEndPoint : String get() = BASE_URL + "auth/login"
    val authenticateUser : String get() = BASE_URL + "auth/authenticateUser"
    val getAccessories : String get() = BASE_URL + "common/getaccessories"
    val registerUser : String get() = BASE_URL + "auth/registerUser"
    val updateProfile : String get() = BASE_URL + "users"
    val forgotPassword : String get() = BASE_URL + "auth/forgotPassowrdEmailCheck"
    val resetPassword : String get() = BASE_URL + "auth/resetPassword"
    val getStocks : String get() = BASE_URL + "stocks"
    val follow : String get() = "/follow"
    val followers : String get() = "/followers"
    val trades : String get() = BASE_URL + "trades"
    val stocks : String get() = BASE_URL + "stocks/"
    val comment : String get() = "/comment"
    val comments : String get() = "/comments/"
    val uploadProfile : String get() = BASE_URL + "upload/profile"
    val users : String get() = BASE_URL + "users/"
    val _return : String get() = "/return"
    val holdings : String get() = "/holdings"
    val followings : String get() = "/followings"
    val notifications : String get() = BASE_URL + "notifications"
    val acceptfollow : String get() = "/acceptfollow"
    val returnGraph : String get() = "/return/graph"
    val uploadFile : String get() =  BASE_URL + "upload/uploadfile"
}