package com.sts.investpuzzle.features.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutSetttingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingScreen : BaseFragment<SettingScreenViewModel, LayoutSetttingBinding>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutSetttingBinding.inflate(inflater, container, false))
        withViewModel<SettingScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.txvSignOut.setOnClickListener(this)
        viewBind.lytEditProfile.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.txvSignOut -> {
                viewModel.signout()
                navigationService.openStartupScreen()
            }
            R.id.lytEditProfile -> {
                navigationService.openEditProfileScreen()
            }
        }
    }

}