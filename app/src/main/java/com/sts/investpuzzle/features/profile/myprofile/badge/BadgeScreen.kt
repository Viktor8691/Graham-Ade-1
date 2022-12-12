package com.sts.investpuzzle.features.profile.myprofile.badge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutBadgesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BadgeScreen : BaseFragment<BadgeScreenViewModel, LayoutBadgesBinding>(){

    private val badgeAdapter = BadgeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutBadgesBinding.inflate(inflater, container, false))
        withViewModel<BadgeScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.rcvBadges.layoutManager = GridLayoutManager(requireContext(), 3)
        viewBind.rcvBadges.adapter = badgeAdapter
    }

}