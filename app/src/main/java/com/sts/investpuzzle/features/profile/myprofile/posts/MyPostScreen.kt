package com.sts.investpuzzle.features.profile.myprofile.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutMyForumsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPostScreen : BaseFragment<MyPostViewModel, LayoutMyForumsBinding>(){

    private val forumAdapter = PostAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutMyForumsBinding.inflate(inflater, container, false))
        withViewModel<MyPostViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvMyForums.layoutManager = layoutManager
        viewBind.rcvMyForums.adapter = forumAdapter
    }
}