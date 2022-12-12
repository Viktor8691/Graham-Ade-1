package com.sts.investpuzzle.features.profile.myprofile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.ImagePickerConfig
import com.esafirm.imagepicker.features.ImagePickerMode
import com.esafirm.imagepicker.features.cameraonly.CameraOnlyConfig
import com.esafirm.imagepicker.features.registerImagePicker
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.constants.FLAG_BASE_URL
import com.sts.investpuzzle.core.navigation.Screens
import com.sts.investpuzzle.databinding.DialogPickupImageBinding
import com.sts.investpuzzle.databinding.LayoutMyProfileBinding
import com.sts.investpuzzle.extensions.observeEvent
import com.sts.investpuzzle.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyProfileScreen : BaseFragment<MyProfileScreenViewModel, LayoutMyProfileBinding>(){

    private lateinit var myProfileAdapter: MyProfileAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutMyProfileBinding.inflate(inflater, container, false))
        withViewModel<MyProfileScreenViewModel> {
            observeEvent(isProfileUpdated) {
                if (it) loadData()
            }
        }
        return viewBind.root
    }

    @SuppressLint("ResourceType")
    override fun setUp() {
        myProfileAdapter = MyProfileAdapter(requireContext(), childFragmentManager)
        viewBind.viewPager.adapter = myProfileAdapter
        viewBind.lytHoldings.setOnClickListener(this)
        viewBind.lytFollowings.setOnClickListener(this)
        viewBind.imvAvatarPicker.setOnClickListener(this)
        viewBind.lytFollowers.setOnClickListener(this)
        loadData()
    }

    private fun loadData(){
        viewBind.txvUserName.text = BaseViewModel.userDetail?.userFullName
        Glide.with(requireContext()).load(BaseViewModel.userDetail?.photoUrl).placeholder(R.drawable.default_img).dontAnimate().into(viewBind.imvAvatar)
        viewBind.txvBio.text = BaseViewModel.userDetail?.bio
    }

    // configure for gallery
    private val galleryConfigure = ImagePickerConfig{
        mode = ImagePickerMode.SINGLE
        isShowCamera = true
    }
    private val galleryLauncher = registerImagePicker {
        if (it.isNotEmpty()){
            Glide.with(this).load(it.first().uri).into(viewBind.imvAvatar)
            viewModel.uploadProfilePicture(it.first())
        }
    }

    // configure for Image
    val cameraLauncher = registerImagePicker {
        if (it.isNotEmpty()) {
            Glide.with(this).load(it.first().uri).into(viewBind.imvAvatar)
            viewModel.uploadProfilePicture(it.first())
        }
    }


    private fun openImagePicker(){
        val dialogViewBind = DialogPickupImageBinding.inflate(LayoutInflater.from(context), viewBind.root, false)
        val dialog = Utils.customDialog(requireContext(), dialogViewBind)

        dialogViewBind.txvOpenCamera.setOnClickListener {
            cameraLauncher.launch(CameraOnlyConfig())
            dialog.dismiss()
        }

        dialogViewBind.txvOpenGallery.setOnClickListener {
            dialog.dismiss()
            galleryLauncher.launch(galleryConfigure)
        }

        dialog.show()
    }

    @SuppressLint("ResourceType")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.lytFollowings -> {
                mainScreen?.addNewFragment(Screens.getFollowingScreen())
            }
            R.id.lytHoldings -> {
                mainScreen?.addNewFragment(Screens.getHoldingScreen())
            }
            R.id.lytFollowers -> {
                mainScreen?.addNewFragment(Screens.getFollowersScreen())
            }
            R.id.imvAvatarPicker -> {
                openImagePicker()
            }
        }
    }
}