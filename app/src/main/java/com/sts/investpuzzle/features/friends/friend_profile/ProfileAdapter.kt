package com.sts.investpuzzle.features.friends.friend_profile

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.sts.investpuzzle.R
import com.sts.investpuzzle.features.profile.myprofile.badge.BadgeScreen
import com.sts.investpuzzle.features.profile.myprofile.groups.GroupScreen
import com.sts.investpuzzle.features.profile.myprofile.posts.MyPostScreen
import com.sts.investpuzzle.features.profile.myprofile.portfolio.PortfolioScreen

class ProfileAdapter(private val context: Context, fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    val pageTiles = listOf(R.string.portfolio, R.string.posts, R.string.groups, R.string.badges)

    override fun getCount(): Int {
        return pageTiles.size
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return PortfolioScreen()
            1 -> return  MyPostScreen()
            2 -> return GroupScreen()
            else -> return BadgeScreen()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.getString(pageTiles.get(position))
    }
}