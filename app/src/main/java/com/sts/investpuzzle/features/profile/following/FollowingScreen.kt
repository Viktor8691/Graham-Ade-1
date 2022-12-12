package com.sts.investpuzzle.features.profile.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenFollowingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowingScreen : BaseFragment<FollowingScreenViewModel, ScreenFollowingBinding>(){

    private val followingAdapter = FollowingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenFollowingBinding.inflate(inflater, container, false))
        withViewModel<FollowingScreenViewModel> {  }
        return viewBind.root
    }
    override fun setUp() {
        viewBind.backButton.setOnClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvFollowing.layoutManager = layoutManager
        viewBind.rcvFollowing.adapter = followingAdapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                mainScreen?.childFragmentManager?.popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}