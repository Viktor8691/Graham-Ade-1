package com.sts.investpuzzle.features.profile.myprofile.groups

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.databinding.ItemGroupBinding

class GroupAdapter  : RecyclerView.Adapter<GroupAdapter.ViewHolder>(){

    private lateinit var binding: ItemGroupBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView : ItemGroupBinding) : RecyclerView.ViewHolder(itemView.root)
}