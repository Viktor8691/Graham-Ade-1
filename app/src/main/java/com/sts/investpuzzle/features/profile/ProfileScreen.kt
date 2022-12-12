package com.sts.investpuzzle.features.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.FragmentTransaction
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileScreen : BaseFragment<ProfileScreenViewModel, ScreenProfileBinding>(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenProfileBinding.inflate(inflater, container, false))

        withViewModel<ProfileScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        openMyProfileScreen()
    }

    @SuppressLint("ResourceType")
    private fun openMyProfileScreen(){
        navigationService.openMyProfileScreen(childFragmentManager.beginTransaction(), R.id.frmContainer)
    }

    override fun onClick(v: View?) {}


    enum class SearchStatus {
        PEOPLE,
        COMPANY,
        GROUP
    }
}