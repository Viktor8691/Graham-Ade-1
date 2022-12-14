package com.sts.investpuzzle.features.profile.myprofile.groups.add_participants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.databinding.ItemUserPictureBinding

class ParticipantsAdapter : RecyclerView.Adapter<ParticipantsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  binding = ItemUserPictureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder (itemView : ItemUserPictureBinding) : RecyclerView.ViewHolder(itemView.root)
}