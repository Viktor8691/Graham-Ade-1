package com.sts.investpuzzle.features.main_fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.constants.ScreenTag
import com.sts.investpuzzle.core.navigation.Screens
import com.sts.investpuzzle.databinding.ScreenMainBinding
import com.sts.investpuzzle.features.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : BaseFragment<MainScreenViewModel, ScreenMainBinding>() {

    private var currentTap : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenMainBinding.inflate(inflater, container, false))
        withViewModel<MainScreenViewModel> {  }
        return viewBind.root
    }

    override fun onResume() {
        super.onResume()
        mainScreen = this
    }

    override fun setUp() {
        selectTab(R.id.menuStocks)
        viewBind.lytSearch.imvNotification.setOnClickListener(this)
        viewBind.lytSearch.imvMessage.setOnClickListener(this)
        viewBind.lytSearch.imvSetting.setOnClickListener(this)
        viewBind.bottomNav.visibility = View.VISIBLE
        viewBind.bottomNav.setOnItemSelectedListener { item ->
            selectTab(item.itemId)
            true
        }

        viewBind.lytSearch.txvPeople.setOnClickListener(this)
        viewBind.lytSearch.txvCompany.setOnClickListener(this)
        viewBind.lytSearch.txvGroup.setOnClickListener(this)

        viewBind.lytSearch.edtSearchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length > 3) {
                    viewBind.lytSearch.lytSearchTab.visibility = View.VISIBLE
                    searchProcess(s.toString())
                }else {
                    viewBind.lytSearch.lytSearchTab.visibility = View.GONE
                    val currentFragment = childFragmentManager.findFragmentByTag(ScreenTag.SEARCH_SCREEN.name)
                    if (currentFragment != null && currentFragment.isVisible) {
                        selectTab(currentTap)
                    }
                }
            }
        })
    }

    private fun searchProcess(query : String){
        viewModel.search(query)
        /*val currentFragment = childFragmentManager.findFragmentByTag(ScreenTag.SEARCH_SCREEN.name)
        if (currentFragment != null && currentFragment.isVisible) return
        addNewFragment(Screens.getSearchScreen(), ScreenTag.SEARCH_SCREEN.name)*/
    }

    private fun changeSearchStatus(searchStatus: ProfileScreen.SearchStatus) {

        viewBind.lytSearch.txvPeople.setBackgroundResource(R.drawable.bg_empty)
        viewBind.lytSearch.txvCompany.setBackgroundResource(R.drawable.bg_empty)
        viewBind.lytSearch.txvGroup.setBackgroundResource(R.drawable.bg_empty)

        viewBind.lytSearch.txvPeople.setTextColor(resources.getColor(R.color.black))
        viewBind.lytSearch.txvCompany.setTextColor(resources.getColor(R.color.black))
        viewBind.lytSearch.txvGroup.setTextColor(resources.getColor(R.color.black))

        if (searchStatus == ProfileScreen.SearchStatus.PEOPLE){
            viewBind.lytSearch.txvPeople.setBackgroundResource(R.drawable.bg_orange_round)
            viewBind.lytSearch.txvPeople.setTextColor(resources.getColor(R.color.white))
        }

        if (searchStatus == ProfileScreen.SearchStatus.COMPANY) {
            viewBind.lytSearch.txvCompany.setBackgroundResource(R.drawable.bg_orange_round)
            viewBind.lytSearch.txvCompany.setTextColor(resources.getColor(R.color.white))
        }

        if (searchStatus == ProfileScreen.SearchStatus.GROUP) {
            viewBind.lytSearch.txvGroup.setBackgroundResource(R.drawable.bg_orange_round)
            viewBind.lytSearch.txvGroup.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun selectTab(tabId : Int){
        currentTap = tabId

        var currentFragment : Fragment? = null
        val fragments = childFragmentManager.fragments

        fragments.map {
            val tag = it.tag.toString()
            if (!TextUtils.equals(tag, R.id.menuStocks.toString())
                && !TextUtils.equals(tag, R.id.menuNews.toString())
                && !TextUtils.equals(tag, R.id.menuRanking.toString())
                && !TextUtils.equals(tag, R.id.menuDailyMovers.toString())
                && !TextUtils.equals(tag, R.id.menuProfile.toString())){
                childFragmentManager.popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        for (f in fragments){
            if (f.isVisible){
                currentFragment = f
                break
            }
        }

        Log.d("Fragment counts ====> ", fragments.size.toString())

        val newFragment = childFragmentManager.findFragmentByTag(tabId.toString())
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        val transaction = childFragmentManager.beginTransaction()
        if (newFragment == null){
            if (tabId == R.id.menuStocks) {
                transaction.add(R.id.mainContainer, Screens.getStockScreen(), tabId.toString())
            }
            if (tabId == R.id.menuNews) {
                transaction.add(R.id.mainContainer, Screens.getNewsScreen(), tabId.toString())
            }
            if (tabId == R.id.menuRanking){
                transaction.add(R.id.mainContainer, Screens.getRankingScreen(), tabId.toString())
            }
            if (tabId == R.id.menuDailyMovers){
                transaction.add(R.id.mainContainer, Screens.getMoverScreen(), tabId.toString())
            }
            if (tabId == R.id.menuProfile){
                transaction.add(R.id.mainContainer, Screens.getProfileScreen(), tabId.toString())
            }
        }

        if (currentFragment != null){
            transaction.hide(currentFragment)
        }
        if (newFragment != null){
            transaction.show(newFragment)
        }
        transaction.commitNow()
    }

    fun addNewFragment(screen : Fragment, tag : String = ""){
        val ft = childFragmentManager.beginTransaction()
        ft.add(R.id.mainContainer, screen, tag)
        ft.addToBackStack("")
        ft.commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.txvPeople -> {
                changeSearchStatus(ProfileScreen.SearchStatus.PEOPLE)
            }
            R.id.txvCompany -> {
                changeSearchStatus(ProfileScreen.SearchStatus.COMPANY)
            }
            R.id.txvGroup -> {
                changeSearchStatus(ProfileScreen.SearchStatus.GROUP)
            }
            R.id.imvSetting -> {
                addNewFragment(Screens.getSettingScreen())
            }
            R.id.imvMessage -> {
                addNewFragment(Screens.getMessageScreen())
            }
            R.id.imvNotification -> {
                addNewFragment(Screens.getNotificationScreen())
            }
        }
    }
}