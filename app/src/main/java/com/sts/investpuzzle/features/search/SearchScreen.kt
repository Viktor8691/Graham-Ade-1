package com.sts.investpuzzle.features.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutSearchScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchScreen : BaseFragment<SearchScreenViewModel, LayoutSearchScreenBinding>() {

    private val searchAdapter : SearchAdapter = SearchAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutSearchScreenBinding.inflate(inflater, container, false))
        withViewModel<SearchScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvSearchList.layoutManager = layoutManager
        viewBind.rcvSearchList.adapter = searchAdapter
    }
}