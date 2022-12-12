package com.sts.investpuzzle.features.profile.myprofile.portfolio

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.sts.investpuzzle.base.BaseFragment
import com.sts.investpuzzle.core.data.network.model.portfolio.GetRetrunResData
import com.sts.investpuzzle.core.data.network.model.stock.Coordinate
import com.sts.investpuzzle.core.data.network.model.stock.ReturnGraphResData
import com.sts.investpuzzle.databinding.LayoutMyProfileBinding
import com.sts.investpuzzle.databinding.LayoutPortfolioBinding
import com.sts.investpuzzle.extensions.observeEvent
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class PortfolioScreen : BaseFragment<PortfolioScreenViewModel, LayoutPortfolioBinding>(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setupViewBinding(LayoutPortfolioBinding.inflate(inflater, container, false))
        withViewModel<PortfolioScreenViewModel> {
            observeEvent(returns) { loadReturns(it) }
            observeEvent(returnGraph) {loadGraph(it.d1)}
        }
        return viewBind.root
    }

    override fun setUp() {
        initGraphView()
    }

    private fun loadReturns(data : GetRetrunResData){
        viewBind.txvReturns.text = data.returns.toString()
        viewBind.timeRange.addOnSegmentClickListener {
            when (it.absolutePosition){
                0 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.d1) }
                1 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.w1) }
                2 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.m1) }
                3 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.m3) }
                4 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.m6) }
                5 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.y1) }
                6 -> viewModel.returnGraph.value?.peekContent()?.let { it1 -> loadGraph(it1.all) }
            }

        }
    }


    private fun initGraphView(){
        viewBind.returnsGraph.setTouchEnabled(true)
        viewBind.returnsGraph.setBackgroundColor(Color.WHITE)
        viewBind.returnsGraph.setTouchEnabled(true)
        viewBind.returnsGraph.isDragEnabled = true
        viewBind.returnsGraph.setScaleEnabled(true)
        viewBind.returnsGraph.setPinchZoom(true)
        viewBind.returnsGraph.axisRight.isEnabled = false
        viewBind.returnsGraph.description.text = ""
        viewBind.returnsGraph.isAutoScaleMinMaxEnabled = false
        viewBind.returnsGraph.xAxis.disableGridDashedLine()


        val xAxis =viewBind.returnsGraph.xAxis
        xAxis.valueFormatter = object : IndexAxisValueFormatter() {
            private val mFormat = SimpleDateFormat("HH:mm")
            override fun getFormattedValue(value: Float): String {
                return mFormat.format(Date(value.toLong()))
            }
        }
    }

    private fun loadGraph(graphData : List<Coordinate>) {
        val values = arrayListOf<Entry>()
        graphData.map {
            values.add(Entry(it.createdAt.toFloat(), it.returns))
        }
        val set1 : LineDataSet
        if (viewBind.returnsGraph.data != null && viewBind.returnsGraph.data.dataSetCount > 0){
            set1 = viewBind.returnsGraph.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            viewBind.returnsGraph.data.notifyDataChanged()
            viewBind.returnsGraph.notifyDataSetChanged()
        }else {
            set1 = LineDataSet(values, "")
            set1.setColor(Color.RED)
            set1.setDrawCircles(false)
            set1.lineWidth = 2f
            set1.fillColor = Color.BLACK

            val dataSets = arrayListOf<ILineDataSet>()
            dataSets.add(set1)

            val data = LineData(dataSets)
            viewBind.returnsGraph.data = data
        }
        viewBind.returnsGraph.invalidate()
    }


}