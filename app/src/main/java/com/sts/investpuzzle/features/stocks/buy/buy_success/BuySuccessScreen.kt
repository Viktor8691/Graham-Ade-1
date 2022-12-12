package com.sts.investpuzzle.features.stocks.buy.buy_success

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sts.investpuzzle.R
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.databinding.ScreenCongratulatePurchaseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuySuccessScreen : BaseFragment<BuySuccessViewModel, ScreenCongratulatePurchaseBinding>() {

    companion object {
        const val STOCK_DETAIL_ARG = "buy_success_screen_arg_1"
        const val BUY_STOCK_RESPONSE_ARG = "buy_success_screen_arg_2"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setupViewBinding(ScreenCongratulatePurchaseBinding.inflate(inflater, container, false))
        withViewModel<BuySuccessViewModel> {  }
        return viewBind.root
    }

    @SuppressLint("SetTextI18n")
    override fun setUp() {
        viewBind.txvDismiss.setOnClickListener(this)
        viewBind.txvCongratulation.text = "${getString(R.string.congratulate_you_bought)} \n ${viewModel.stockDetail.symbol}"
        viewBind.txvStockSymbol.text = "${viewModel.buyStockRes.data.quantity} ${viewModel.stockDetail.symbol}"
        viewBind.txvPrice.text = "$${viewModel.buyStockRes.data.amount} USD"
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.txvDismiss -> {
                navigationService.goBack()
            }
        }
    }
}