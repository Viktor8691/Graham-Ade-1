package com.sts.investpuzzle.features.stocks.stock_detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.stock.StockComment
import com.sts.investpuzzle.databinding.DialogTradeBinding
import com.sts.investpuzzle.databinding.ScreenStockDetailBinding
import com.sts.investpuzzle.extensions.RecyclerViewTouchListener
import com.sts.investpuzzle.extensions.observeEvent
import com.sts.investpuzzle.features.friends.friend_profile.FriendProfileScreen
import com.sts.investpuzzle.features.stocks.buy.BuyStockScreen
import com.sts.investpuzzle.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockDetailScreen : BaseFragment<StockDetailViewModel, ScreenStockDetailBinding>()  {

    companion object {
        const val ALL_STOCK_SCREEN_ARG = "allStockScree"
    }

    private val commentAdapter = StockCommentAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenStockDetailBinding.inflate(inflater, container, false))

        withViewModel<StockDetailViewModel> {
            observeEvent(viewModel.comments){
                loadComments(it)
            }
        }

        return viewBind.root
    }

    override fun setUp() {
        viewBind.txvPost.setOnClickListener(this)
        viewBind.backButton.setOnClickListener(this)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.rcvComment.layoutManager = layoutManager
        viewBind.rcvComment.adapter = commentAdapter
        viewBind.rcvComment.addOnItemTouchListener(RecyclerViewTouchListener(requireContext(), viewBind.rcvComment, object : RecyclerViewTouchListener.ClickListener{
            override fun onClick(view: View, position: Int) {
                val bundle = Bundle()
                bundle.apply { putString(FriendProfileScreen.FRIEND_ID, commentAdapter.getItem(position).user.id) }
                navigationService.openFriendProfileScreen(bundle)
            }
        }))

        viewBind.txvTrade.setOnClickListener(this)
        viewBind.imvShowStockInfo.setOnClickListener(this)

        loadData()
    }

    private fun loadData(){
        viewBind.txvStockName.text = viewModel.stockDetail.name
    }

    private fun loadComments(comments : List<StockComment>){
        commentAdapter.loadData(comments.toMutableList())
    }

    @SuppressLint("SetTextI18n")
    private fun showTradeDialog(){
        val dialogViewBind = DialogTradeBinding.inflate(LayoutInflater.from(requireContext()), viewBind.root, false)
        val dialog = Utils.customDialog(requireContext(), dialogViewBind)

        dialogViewBind.txvStockName.text = "1 ${viewModel.stockDetail.symbol}"
        dialogViewBind.txvVolAndPrice.text = "Available ${viewModel.stockDetail.volume} - ${Utils.getTotalPrice(viewModel.stockDetail)}"
        dialogViewBind.txvPrice.text = "$${viewModel.stockDetail.price}"

        dialogViewBind.txvBuy.setOnClickListener {
            dialog.dismiss()
            val bundle = Bundle()
            bundle.apply { putParcelable(BuyStockScreen.STOCK_DETAIL_SCREEN_ARG, viewModel.stockDetail) }
            navigationService.openBuyStockScreen(bundle)
        }

        dialogViewBind.txvCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                navigationService.goBack()
            }
            R.id.txvTrade -> {
                showTradeDialog()
            }
            R.id.imvShowStockInfo -> {}
            R.id.txvPost -> {
                viewModel.putComment(viewBind.edtComment.text.toString())
            }
        }
    }
}