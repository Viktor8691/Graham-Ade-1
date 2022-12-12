package com.sts.investpuzzle.features.stocks.following

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.databinding.ItemFollowingInStockBinding

class StockPpFollowingAdapter : RecyclerView.Adapter<StockPpFollowingAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFollowingInStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner  class ViewHolder(itemView : ItemFollowingInStockBinding)  : RecyclerView.ViewHolder(itemView.root)
}