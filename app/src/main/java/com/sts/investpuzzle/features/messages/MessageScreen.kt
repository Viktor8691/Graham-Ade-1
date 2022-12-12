package com.sts.investpuzzle.features.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutMessageBinding
import com.sts.investpuzzle.databinding.LayoutSearchScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageScreen : BaseFragment<MessageScreenViewModel, LayoutMessageBinding>(){

    private val messageAdapter = MessageAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutMessageBinding.inflate(inflater, container, false))
        withViewModel<MessageScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvMessage.layoutManager = layoutManager
        viewBind.rcvMessage.adapter = messageAdapter
    }

}