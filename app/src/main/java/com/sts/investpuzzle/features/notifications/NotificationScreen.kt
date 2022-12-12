package com.sts.investpuzzle.features.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.notification.Notification
import com.sts.investpuzzle.databinding.LayoutNotificationBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint

interface NotiAdapterEventListener {
    fun acceptOrReject(notification: Notification, isAccept : Boolean)
}

@AndroidEntryPoint
class NotificationScreen : BaseFragment<NotificationScreenViewModel, LayoutNotificationBinding>() , NotiAdapterEventListener {

    private var notificationAdapter = NotificationAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(LayoutNotificationBinding.inflate(inflater, container, false))
        withViewModel<NotificationScreenViewModel> {
            observeEvent(notifications) {
                loadNoti(it)
            }
        }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvNotification.layoutManager = layoutManager
        viewBind.rcvNotification.adapter = notificationAdapter
    }

    private fun loadNoti(data : List<Notification>){
        notificationAdapter.loadData(data.toMutableList())
    }

    override fun acceptOrReject(notification: Notification, isAccept : Boolean) {
        viewModel.acceptOrRejectFollow(notification.sender.id, isAccept)
    }
}