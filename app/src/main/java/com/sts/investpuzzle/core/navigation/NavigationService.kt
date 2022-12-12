package com.sts.investpuzzle.core.navigation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.sts.investpuzzle.features.main_activity.MainActivity
import com.sts.investpuzzle.R
import com.sts.investpuzzle.constants.ScreenTag

class NavigationService(cicerone: Cicerone<Router>) : INavigationService {
    private val router = cicerone.router
    private val navigationHolder = cicerone.getNavigatorHolder()

    override fun attachToActivity(context: Context) {
        context as MainActivity
        navigationHolder.setNavigator(AppNavigator(context, R.id.frmContainer))
    }

    override fun openStartupScreen() {
        newRootScreen(Screens.getStartupScreen())
    }

    override fun openSignInScreen() {
        navigateTo(Screens.getSignInScreen())
    }

    override fun openSignupScreen() {
        navigateTo(Screens.getSignupScreen())
    }

    override fun openInputOTPScreen(bundle: Bundle) {
        navigateTo(Screens.GetInputOTPScreen(bundle))
    }

    override fun openForgotPwdScreen() {
        navigateTo(Screens.getForgotPwdScreen())
    }

    override fun openInputUserInfoScreen(bundle: Bundle) {
        navigateTo(Screens.GetInputUserInfoScreen(bundle))
    }

    override fun openWelcomeSignupScreen() {
        newRootScreen(Screens.getWelcomeSignupScreen())
    }

    override fun openResetScreen(bundle: Bundle) {
        navigateTo(Screens.GetResetPasswordScreen(bundle))
    }

    override fun openResetPwdSuccessScreen() {
        newRootScreen(Screens.getResetPwdSuccessScreen())
    }

    @SuppressLint("ResourceType")
    override fun openMyProfileScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.replace(containerId, Screens.getMyProfileScreen(), "")
        fragmentTransaction.commit()
    }

    @SuppressLint("ResourceType")
    override fun openSearchScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.add(containerId, Screens.getSearchScreen(), ScreenTag.SEARCH_SCREEN.name)
        fragmentTransaction.addToBackStack(null).commit()
    }

    @SuppressLint("ResourceType")
    override fun openPortfolioScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.replace(containerId, Screens.getPortfolioScreen(), "")
        fragmentTransaction.commit()
    }

    @SuppressLint("ResourceType")
    override fun openGroupScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.replace(containerId, Screens.getGroupScreen())
        fragmentTransaction.commit()
    }

    @SuppressLint("ResourceType")
    override fun openMyForumScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.replace(containerId, Screens.getMyForumScreen())
        fragmentTransaction.commit()
    }

    @SuppressLint("ResourceType")
    override fun openBadgeScreen(fragmentTransaction: FragmentTransaction, containerId: Int) {
        fragmentTransaction.replace(containerId, Screens.getBadgeScreen())
        fragmentTransaction.commit()
    }

    override fun openMainScreen() {
        newRootScreen(Screens.getMainScreen())
    }

    override fun openCreateGroupScreen() {
        navigateTo(Screens.getCreateGroupScreen())
    }

    override fun openAddParticipantScreen() {
        navigateTo(Screens.getAddParticipantScreen())
    }

    override fun openStockDetailScreen(bundle: Bundle) {
        navigateTo(Screens.GetStockDetailScreen(bundle))
    }

    override fun openBuyStockScreen(bundle: Bundle) {
        navigateTo(Screens.GetBuyStockScreen(bundle))
    }

    override fun openBuySuccessScreen(bundle: Bundle) {
        replaceScreen(Screens.GetBuySuccessScreen(bundle))
    }

    override fun openEditProfileScreen() {
        navigateTo(Screens.getEditProfileScreen())
    }

    override fun openFriendProfileScreen(bundle: Bundle) {
        navigateTo(Screens.GetFriendProfileScreen(bundle))
    }

    override fun goBack() {
        back()
    }


    private fun replaceScreen(screen: Screen){
        router.replaceScreen(screen)
        /*CoroutineScope(Dispatchers.Main).launch {
            router.replaceScreen(screen)
        }*/
    }

    private fun newRootScreen(screen: Screen){
        router.newRootScreen(screen)
        /*CoroutineScope(Dispatchers.Main).launch {
            router.newRootScreen(screen)
        }*/
    }

    private fun navigateTo(screen: Screen){
        router.navigateTo(screen)
        /*CoroutineScope(Dispatchers.Main).launch {
            router.navigateTo(screen)
        }*/
    }

    private fun back(){
        router.exit()
        /*CoroutineScope(Dispatchers.Main).launch {
            router.exit()
        }*/
    }
}