package com.sts.investpuzzle.features.profile.followers

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sts.investpuzzle.R
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import com.sts.investpuzzle.databinding.ItemFollowerBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.ViewHolder>() {

    private val allData : MutableList<User> = mutableListOf()
    private lateinit var context : Context

    fun loadData(data : MutableList<User>) {
        val lastPosition = allData.size - 1
        allData.addAll(data)
        notifyItemRangeInserted(lastPosition, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemFollowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(allData.get(position)){
                Glide.with(context).load(this.photoUrl).placeholder(R.drawable.default_img).dontAnimate().into(binding.imvAvatar)
                binding.txvFullName.text = this.userFullName
            }
        }
    }

    override fun getItemCount(): Int = allData.size

    inner class  ViewHolder(val binding : ItemFollowerBinding) : RecyclerView.ViewHolder(binding.root)
}