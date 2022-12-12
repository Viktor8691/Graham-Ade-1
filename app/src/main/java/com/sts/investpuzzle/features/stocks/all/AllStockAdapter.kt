package com.sts.investpuzzle.features.stocks.all

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sts.investpuzzle.R
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.databinding.ItemStockBinding
import com.sts.investpuzzle.extensions.RecyclerViewBottomReachedListener
import kotlin.math.roundToInt

class AllStockAdapter  : RecyclerView.Adapter<AllStockAdapter.ViewHolder>(){

    lateinit var onBottomReachedListener : RecyclerViewBottomReachedListener

    private val allData = mutableListOf<Stock>()
    private lateinit var context: Context

    @SuppressLint("NotifyDataSetChanged")
    fun clearDataAndLoadData(data : MutableList<Stock>){
        allData.clear()
        allData.addAll(data)
        notifyDataSetChanged()
    }

    fun loadData(data : MutableList<Stock>){
        val lastPosition = allData.size - 1
        allData.addAll(data)
        notifyItemRangeInserted(lastPosition, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ItemStockBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(allData.get(position)){
                Glide.with(context).load(this.image).placeholder(R.drawable.default_img).dontAnimate().into(binding.imvStockLogo)
                binding.txvStockName.text = this.name
                binding.txvSymbol.text = this.symbol
                binding.txvPrice.text = "\$ ${this.price}"

                val percent = (this.changesPercentage * 100.0).roundToInt() / 100.0
                binding.txvPercent.text = "($percent%)"
            }
        }
        if (position == allData.size -1 )
            onBottomReachedListener.onBottomReached(position)

    }

    override fun getItemCount(): Int = allData.size

    fun getItem(position : Int) : Stock = allData.get(position)

    fun addOnBottomReachedListener(listener: RecyclerViewBottomReachedListener) {
        onBottomReachedListener = listener
    }

    inner class ViewHolder (val binding : ItemStockBinding) : RecyclerView.ViewHolder(binding.root)
}