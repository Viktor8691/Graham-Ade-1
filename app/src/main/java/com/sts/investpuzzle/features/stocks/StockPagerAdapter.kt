package com.sts.investpuzzle.features.stocks

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sts.investpuzzle.features.stocks.all.AllStockScreen
import com.sts.investpuzzle.features.stocks.following.StockPpFollowingScreen

class StockPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm)   {

    val pageTitles = listOf("Stocks", "Feed")

    override fun getCount(): Int {
        return pageTitles.size
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return AllStockScreen()
        return StockPpFollowingScreen()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pageTitles.get(position)
    }
}