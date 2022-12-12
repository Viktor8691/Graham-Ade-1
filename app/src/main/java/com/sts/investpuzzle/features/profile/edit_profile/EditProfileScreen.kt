package com.sts.investpuzzle.features.profile.edit_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.databinding.ScreenEditProfileBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProfileScreen : BaseFragment<EditProfileViewModel, ScreenEditProfileBinding>(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenEditProfileBinding.inflate(inflater, container, false))
        withViewModel<EditProfileViewModel> {
            observeEvent(isProfileUpdated){
                if (it) navigationService.goBack()
            }
        }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.edtName.setText(BaseViewModel.userDetail?.userFullName)
        viewBind.edtBio.setText(BaseViewModel.userDetail?.bio)
        viewBind.txvSave.setOnClickListener(this)
        viewBind.backButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txvSave -> {
                viewModel.editProfile(viewBind.edtName.text.toString(), viewBind.edtBio.text.toString())
            }
            R.id.backButton -> {
                navigationService.goBack()
            }
        }
    }

}