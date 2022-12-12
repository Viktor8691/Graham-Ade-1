package com.sts.investpuzzle.features.user_management.input_user_detail

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.sts.investpuzzle.constants.FLAG_BASE_URL
import com.sts.investpuzzle.core.data.network.model.accessories.Country
import com.sts.investpuzzle.databinding.ItemCountryBinding

class CountryListAdapter(private val allData: MutableList<Country>) : RecyclerView.Adapter<CountryListAdapter.ViewHolder>(){

    private lateinit var context : Context
    private lateinit var binding: ItemCountryBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder){
            with(allData.get(position)){
                Glide.with(context).load("$FLAG_BASE_URL/${this.code.lowercase()}.png").into(binding.imvFlag)
                binding.txvCountryName.text = this.name
            }
        }
    }

    override fun getItemCount(): Int = allData.size

    fun getItem(position: Int) : Country = allData.get(position)

    inner class ViewHolder (val binding : ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)
}