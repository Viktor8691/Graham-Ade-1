package com.sts.investpuzzle.features.profile.myprofile.groups.create_group

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.registerImagePicker
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenCreateGroupBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class CreateGroupScreen : BaseFragment<CreateGroupViewModel, ScreenCreateGroupBinding>(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenCreateGroupBinding.inflate(inflater, container, false))
        withViewModel<CreateGroupViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.backButton.setOnClickListener(this)
        viewBind.imvSelectGroupPicture.setOnClickListener(this)
        viewBind.imvSelectParticipant.setOnClickListener(this)
    }

    private val imgPickerConfig = ImagePickerConfig{
        mode = ImagePickerMode.SINGLE
        isShowCamera = true
    }
    private val launcher = registerImagePicker {
        if (it.isNotEmpty())
            Glide.with(this).load(it.first().uri).into(viewBind.imvGroupPicture)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.imvSelectParticipant -> {
                navigationService.openAddParticipantScreen()
            }
            R.id.imvSelectGroupPicture -> {
                launcher.launch(imgPickerConfig)
            }
            R.id.backButton -> {
                navigationService.goBack()
            }
        }

    }
}