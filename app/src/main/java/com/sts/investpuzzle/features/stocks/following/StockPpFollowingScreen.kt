package com.sts.investpuzzle.features.stocks.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutFollowingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockPpFollowingScreen : BaseFragment<StockPpFollowingViewModel, LayoutFollowingBinding>(){

    private val stockPpFollowingAdapter = StockPpFollowingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        setupViewBinding(LayoutFollowingBinding.inflate(inflater, container, false))
        withViewModel<StockPpFollowingViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvFollowingPpInStock.layoutManager = layoutManager
        viewBind.rcvFollowingPpInStock.adapter = stockPpFollowingAdapter
    }

}