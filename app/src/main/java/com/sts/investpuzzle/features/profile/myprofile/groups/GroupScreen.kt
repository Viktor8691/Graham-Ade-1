package com.sts.investpuzzle.features.profile.myprofile.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.LayoutGroupsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GroupScreen : BaseFragment<GroupScreenViewModel, LayoutGroupsBinding>(){

    private val groupAdapter = GroupAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutGroupsBinding.inflate(inflater, container, false))
        withViewModel<GroupScreenViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvGroups.layoutManager = layoutManager
        viewBind.rcvGroups.adapter = groupAdapter
        viewBind.lytCreateNewGroup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.lytCreateNewGroup -> {
                navigationService.openCreateGroupScreen()
            }
        }
    }
}