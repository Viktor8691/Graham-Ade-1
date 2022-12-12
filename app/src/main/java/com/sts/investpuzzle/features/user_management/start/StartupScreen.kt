package com.sts.investpuzzle.features.user_management.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenStartupBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartupScreen : BaseFragment<StartupScreenViewModel, ScreenStartupBinding>(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenStartupBinding.inflate(inflater, container, false))

        withViewModel<StartupScreenViewModel> {
            observeEvent(isSigninSuccess){
                if (it) checkSigInStatus()
            }
        }

        return viewBind.root
    }

    private fun checkSigInStatus(){
        if (viewModel.signInStatus){
            navigationService.openMainScreen()
        }/*else {
            when(nextScreen) {
                1 -> navigationService.openSignInScreen()
                2 -> navigationService.openSignupScreen()
            }
        }*/
    }

    override fun setUp() {
        viewBind.txvSignIn.setOnClickListener(this)
        viewBind.txvSignUp.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txvSignIn -> {
                navigationService.openSignInScreen()
            }
            R.id.txvSignUp -> {
                navigationService.openSignupScreen()
            }
        }
    }

}