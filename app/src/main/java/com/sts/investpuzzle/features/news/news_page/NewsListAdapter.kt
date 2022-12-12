package com.sts.investpuzzle.features.news.news_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sts.investpuzzle.databinding.ItemNewsBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return  10
    }

    inner class ViewHolder(itemView : ItemNewsBinding) : RecyclerView.ViewHolder(itemView.root)
}