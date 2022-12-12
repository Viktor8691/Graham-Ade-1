package com.sts.investpuzzle.features.stocks.buy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenBuyStockBinding
import com.sts.investpuzzle.extensions.observeEvent
import com.sts.investpuzzle.features.stocks.buy.buy_success.BuySuccessScreen
import com.sts.investpuzzle.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyStockScreen : BaseFragment<BuyStockViewModel, ScreenBuyStockBinding>() {

    companion object {
        const val STOCK_DETAIL_SCREEN_ARG = "stock_detail_screen_arg"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenBuyStockBinding.inflate(inflater, container, false))
        withViewModel<BuyStockViewModel> {
            observeEvent(viewModel.purchaseSuccess){
                if (it) openBuySuccessScreen()
            }
        }

        return viewBind.root
    }

    override fun setUp() {
        viewBind.txvConfirmBuy.setOnClickListener(this)
        viewBind.backButton.setOnClickListener(this)
        viewBind.txvStockSymbol.text = "1 ${viewModel.stockDetail?.symbol}"
        viewBind.txvStockSymbol1.text = viewModel.stockDetail?.symbol
        viewBind.txvPrice.text = "$${viewModel.stockDetail?.price}USD"
        viewBind.txvVolAndPrice.text = "Available ${viewModel.stockDetail?.volume} - ${Utils.getTotalPrice(viewModel.stockDetail!!)}"
        viewBind.txvTotalPrice.text = "$0 USD"

        viewBind.edtStockQuantity.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    viewBind.txvTotalPrice.text = "$" +  Utils.getTotalPrice(viewModel.stockDetail?.price!!, s.toString().toInt())
                    viewModel.quantity = s.toString().trim().toInt()
                }else {
                    viewModel.quantity = 0
                    viewBind.txvTotalPrice.text = ""
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun openBuySuccessScreen(){
        val bundle = Bundle()
        bundle.apply {
            putParcelable(BuySuccessScreen.STOCK_DETAIL_ARG, viewModel.stockDetail)
            putParcelable(BuySuccessScreen.BUY_STOCK_RESPONSE_ARG, viewModel.tradeStockRes)
        }
        navigationService.openBuySuccessScreen(bundle)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.backButton -> {
                navigationService.goBack()
            }
            R.id.txvConfirmBuy -> {
                viewModel.buyStock()
            }
        }
    }
}