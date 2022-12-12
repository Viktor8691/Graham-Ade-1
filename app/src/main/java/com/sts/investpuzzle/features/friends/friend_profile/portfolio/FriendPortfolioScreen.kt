package com.sts.investpuzzle.features.friends.friend_profile.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.portfolio.GetRetrunResData
import com.sts.investpuzzle.databinding.LayoutMyProfileBinding
import com.sts.investpuzzle.databinding.LayoutPortfolioBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FriendPortfolioScreen : BaseFragment<FriendPortfolioViewModel, LayoutPortfolioBinding>(){

    companion object {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutPortfolioBinding.inflate(inflater, container, false))
        withViewModel<FriendPortfolioViewModel> {
            observeEvent(returns) { loadReturns(it) }
        }
        return viewBind.root
    }

    override fun setUp() {

    }

    fun loadReturns(data : GetRetrunResData){
        viewBind.txvReturns.text = data.returns.toString()
    }

}