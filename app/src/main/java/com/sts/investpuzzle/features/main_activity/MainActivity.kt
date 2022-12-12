package com.sts.investpuzzle.features.main_activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseActivity
import com.sts.investpuzzle.core.navigation.INavigationService
import com.sts.investpuzzle.core.navigation.Screens
import com.sts.investpuzzle.databinding.ActivityMainBinding
import com.sts.investpuzzle.features.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(){

    @Inject
    lateinit var navigationService: INavigationService

    override val progressView: View get() = viewBind.mProgressView.root
    override val errorView: View get() = viewBind.mErrorView.root

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding(ActivityMainBinding.inflate(layoutInflater))

        withViewModel<MainActivityViewModel> {}

        setUp()
    }

    override fun setUp() {
        navigationService.openStartupScreen()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for (fragment in supportFragmentManager.fragments){
            fragment.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigationService.attachToActivity(this)
    }

    override fun onClick(v: View?) {}
}