package com.sts.investpuzzle.features.news.news_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutNewsPageBinding
import com.sts.investpuzzle.databinding.ScreenNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsPage : BaseFragment<NewsViewModel, LayoutNewsPageBinding>() {

    val newsListAdapter = NewsListAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setupViewBinding(LayoutNewsPageBinding.inflate(inflater, container, false))
        withViewModel<NewsViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvNews.layoutManager = layoutManager
        viewBind.rcvNews.adapter = newsListAdapter
    }
}