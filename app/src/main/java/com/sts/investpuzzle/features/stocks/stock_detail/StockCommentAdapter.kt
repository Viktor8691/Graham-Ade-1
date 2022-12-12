package com.sts.investpuzzle.features.stocks.stock_detail

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.core.data.network.model.stock.StockComment
import com.sts.investpuzzle.databinding.ItemStockCommentBinding

class StockCommentAdapter : RecyclerView.Adapter<StockCommentAdapter.ViewHolder>(){

    private val allData : MutableList<StockComment> = mutableListOf()
    private lateinit var context : Context

    @SuppressLint("NotifyDataSetChanged")
    fun loadData(data : MutableList<StockComment>) {
        allData.clear()
        allData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemStockCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(allData.get(position)) {
                viewBinding.txvFullName.text = this.user.username
                viewBinding.txvComment.text = this.content
            }
        }
    }

    override fun getItemCount(): Int {
        return allData.size
    }

    fun getItem(position: Int) = allData.get(position)

    inner class ViewHolder(val viewBinding : ItemStockCommentBinding) : RecyclerView.ViewHolder(viewBinding.root)
}