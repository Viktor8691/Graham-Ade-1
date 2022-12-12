package com.sts.investpuzzle.features.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.core.data.network.model.notification.Notification
import com.sts.investpuzzle.databinding.ItemNotificationBinding

class NotificationAdapter(val eventListener: NotiAdapterEventListener) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    private lateinit var context : Context

    private val allData : MutableList<Notification> = mutableListOf()

    fun loadData(data : MutableList<Notification>){
        val lastPosition = allData.size - 1
        allData.addAll(data)
        notifyItemRangeInserted(lastPosition, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(allData.get(position)) {
            when(this.type) {
                0 -> {
                    followNoti(holder, position)
                }
            }
        }
    }

    private fun followNoti(holder : ViewHolder, position: Int){
        val noti = allData.get(position)
        holder.bind.followNoti.root.visibility = View.VISIBLE
        with(holder){
            bind.followNoti.txvFullName.text = noti.sender.userFullName
            bind.followNoti.txvAccept.setOnClickListener{
                eventListener.acceptOrReject(noti, true)
            }
            bind.followNoti.txvReject.setOnClickListener {
                eventListener.acceptOrReject(noti, false)
            }
        }
    }

    override fun getItemCount(): Int = allData.size

    inner class ViewHolder (val bind: ItemNotificationBinding) : RecyclerView.ViewHolder(bind.root)
}