package com.sts.investpuzzle.features.profile.followers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import com.sts.investpuzzle.databinding.LayoutFollowersBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowerScreen : BaseFragment<FollowerScreenViewModel, LayoutFollowersBinding>() {

    private val followerAdapter = FollowerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutFollowersBinding.inflate(inflater, container, false))
        withViewModel<FollowerScreenViewModel> {
            observeEvent(followers){
                loadData(it)
            }
        }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.backButton.setOnClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvFollowers.layoutManager = layoutManager
        viewBind.rcvFollowers.adapter = followerAdapter
    }

    private fun loadData(followers : List<User>){
        followerAdapter.loadData(followers.toMutableList())
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                mainScreen?.childFragmentManager?.popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}