package com.sts.investpuzzle.features.stocks.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.stock.Stock
import com.sts.investpuzzle.databinding.LayoutAllStocksBinding
import com.sts.investpuzzle.extensions.RecyclerViewBottomReachedListener
import com.sts.investpuzzle.extensions.RecyclerViewTouchListener
import com.sts.investpuzzle.extensions.observeEvent
import com.sts.investpuzzle.features.stocks.stock_detail.StockDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllStockScreen : BaseFragment<AllStockViewModel, LayoutAllStocksBinding>() {

    private val allStockAdapter : AllStockAdapter = AllStockAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutAllStocksBinding.inflate(inflater, container, false))
        withViewModel<AllStockViewModel> {
            observeEvent(viewModel.stocks){loadStocks(it)}
            observeEvent(viewModel.search) {
                search(it)
            }
        }
        return viewBind.root
    }

    override fun setUp() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvStockList.layoutManager = layoutManager
        viewBind.rcvStockList.adapter = allStockAdapter
        viewBind.rcvStockList.addOnItemTouchListener(RecyclerViewTouchListener(requireContext(), viewBind.rcvStockList, object : RecyclerViewTouchListener.ClickListener {
            override fun onClick(view: View, position: Int) {
                val bundle = Bundle()
                bundle.apply { putParcelable(StockDetailScreen.ALL_STOCK_SCREEN_ARG , allStockAdapter.getItem(position)) }
                navigationService.openStockDetailScreen(bundle)
            }
        }))
        allStockAdapter.addOnBottomReachedListener(object : RecyclerViewBottomReachedListener {
            override fun onBottomReached(position: Int) {
                viewModel.isFirstSearch = false
                viewModel.getStocks(viewModel.getStockReq.keyword)
            }
        })
    }

    private fun search(query : String){
        viewModel.isFirstSearch = true
        viewModel.noStockMore = false
        viewModel.getStocks(query)
    }

    private fun loadStocks(data : List<Stock>){
        if (viewModel.isFirstSearch) {
            allStockAdapter.clearDataAndLoadData(data.toMutableList())
        }else {
            allStockAdapter.loadData(data.toMutableList())
        }
    }
}