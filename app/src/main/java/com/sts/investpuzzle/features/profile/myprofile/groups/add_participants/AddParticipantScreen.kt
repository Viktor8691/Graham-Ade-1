package com.sts.investpuzzle.features.profile.myprofile.groups.add_participants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenAddParticipantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddParticipantScreen : BaseFragment<AddParticipantViewModel, ScreenAddParticipantBinding>(){

    private val participantsAdapter: ParticipantsAdapter = ParticipantsAdapter()
    private val friendsAdapter: FriendsAdapter = FriendsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(ScreenAddParticipantBinding.inflate(inflater, container, false))
        withViewModel<AddParticipantViewModel> {  }
        return viewBind.root
    }

    override fun setUp() {

        viewBind.backButton.setOnClickListener(this)

        val hLayoutManager = LinearLayoutManager(context)
        hLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        viewBind.rcvParticipants.layoutManager = hLayoutManager
        viewBind.rcvParticipants.adapter = participantsAdapter

        val vLayoutManager = LinearLayoutManager(context)
        vLayoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvFriends.layoutManager = vLayoutManager
        viewBind.rcvFriends.adapter = friendsAdapter
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                navigationService.goBack()
            }
        }
    }

}