package com.sts.investpuzzle.features.messages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.databinding.ItemMsgFriendBinding

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private lateinit var binding: ItemMsgFriendBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemMsgFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView : ItemMsgFriendBinding) : RecyclerView.ViewHolder(itemView.root)
}