package com.sts.investpuzzle.features.friends.friend_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenFriendProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendProfileScreen : BaseFragment<FriendProfileViewModel, ScreenFriendProfileBinding>() {

    companion object{
        val FRIEND_ID = "friendId"
    }

    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenFriendProfileBinding.inflate(inflater, container, false))
        withViewModel<FriendProfileViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.backButton.setOnClickListener(this)
        viewBind.lytFollow.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                navigationService.goBack()
            }
            R.id.lytFollow -> {
                viewModel.follow()
            }

        }
    }
}