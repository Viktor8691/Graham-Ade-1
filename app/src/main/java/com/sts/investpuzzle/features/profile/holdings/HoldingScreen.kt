package com.sts.investpuzzle.features.profile.holdings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.portfolio.Holding
import com.sts.investpuzzle.databinding.ScreenHoldingsBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HoldingScreen : BaseFragment<HoldingScreenViewModel, ScreenHoldingsBinding>(){

    private val holdingAdapter = HoldingAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenHoldingsBinding.inflate(layoutInflater, container, false))
        withViewModel<HoldingScreenViewModel> {
            observeEvent(holdings){
                loadHoldings(it)
            }
        }
        return viewBind.root
    }

    override fun setUp() {
        viewBind.backButton.setOnClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvHolding.layoutManager = layoutManager
        viewBind.rcvHolding.adapter = holdingAdapter
    }

    private fun loadHoldings(holdings : List<Holding>){
        holdingAdapter.loadData(holdings.toMutableList())
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.backButton -> {
                mainScreen?.childFragmentManager?.popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

}