package com.sts.investpuzzle.features.stocks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.constants.Common
import com.sts.investpuzzle.constants.SearchPurpose
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.databinding.ScreenStocksBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockScreen : BaseFragment<StockScreenViewModel, ScreenStocksBinding>() {

    private lateinit var stockPagerAdapter: StockPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenStocksBinding.inflate(inflater, container, false))

        withViewModel<StockScreenViewModel> {}

        return viewBind.root
    }

    override fun setUp() {
        stockPagerAdapter = StockPagerAdapter(childFragmentManager)
        viewBind.vpContainer.adapter = stockPagerAdapter
        viewBind.vpContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                when(position) {
                    0 -> Common.searchPurpose = SearchPurpose.STOCK
                    1 -> Common.searchPurpose = SearchPurpose.FEED
                }
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

}