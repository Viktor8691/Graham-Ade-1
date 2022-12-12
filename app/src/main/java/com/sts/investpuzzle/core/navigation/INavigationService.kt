package com.sts.investpuzzle.core.navigation

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentTransaction

interface INavigationService {
    fun attachToActivity(context: Context)
    fun openStartupScreen()
    fun openSignInScreen()
    fun openSignupScreen()
    fun openInputOTPScreen(bundle: Bundle)
    fun openForgotPwdScreen()
    fun openInputUserInfoScreen(bundle: Bundle)
    fun openWelcomeSignupScreen()
    fun openResetScreen(bundle: Bundle)
    fun openResetPwdSuccessScreen()
    fun openMyProfileScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId :  Int)
    fun openSearchScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId :  Int)
    fun openPortfolioScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId: Int)
    fun openGroupScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId: Int)
    fun openMyForumScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId: Int)
    fun openBadgeScreen(fragmentTransaction: FragmentTransaction, @LayoutRes containerId: Int)
    fun openMainScreen()
    fun openCreateGroupScreen()
    fun openAddParticipantScreen()
    fun openStockDetailScreen(bundle: Bundle)
    fun openBuyStockScreen(bundle: Bundle)
    fun openBuySuccessScreen(bundle: Bundle)
    fun openEditProfileScreen()
    fun openFriendProfileScreen(bundle: Bundle)
    fun goBack()
}