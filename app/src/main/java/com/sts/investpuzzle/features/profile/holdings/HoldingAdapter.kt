package com.sts.investpuzzle.features.profile.holdings

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sts.investpuzzle.R
import com.sts.investpuzzle.core.data.network.model.portfolio.Holding
import com.sts.investpuzzle.databinding.ItemHoldingBinding

class HoldingAdapter : RecyclerView.Adapter<HoldingAdapter.ViewHolder>() {

    private val allData : MutableList<Holding> = mutableListOf()
    private lateinit var context: Context

    @SuppressLint("NotifyDataSetChanged")
    fun loadData(data : MutableList<Holding>) {
        allData.clear()
        allData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemHoldingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(allData.get(position)){
                Glide.with(context).load(this.stock.image).placeholder(R.drawable.default_img).dontAnimate().into(binding.imvStockLogo)
                binding.txvStockName.text = this.stock.name
                binding.txvStockSymbol.text = this.stock.symbol
                binding.txvPercent.text = "${this.percent}%"
            }
        }
    }

    override fun getItemCount(): Int {
        return allData.size
    }

    inner class ViewHolder(val binding : ItemHoldingBinding) : RecyclerView.ViewHolder(binding.root)
}