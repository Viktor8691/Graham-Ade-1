package com.sts.investpuzzle.features.news

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sts.investpuzzle.features.news.news_page.NewsPage

class NewsPagerAdapter (fm : FragmentManager) : FragmentStatePagerAdapter(fm) {
    val pageTitles = listOf("All items", "Market", "FED", "Upcomming IPO")
    override fun getCount(): Int {
        return pageTitles.size
    }

    override fun getItem(position: Int): Fragment {
        return NewsPage()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pageTitles.get(position)
    }
}