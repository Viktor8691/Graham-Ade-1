package com.sts.investpuzzle.features.stocks.stock_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.social.FollowReq
import com.sts.investpuzzle.core.data.network.model.stock.*
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class StockDetailViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val stockDetailInteractor: StockDetailInteractor,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<StockDetailInteractor>(schedulerProvider, compositeDisposable, stockDetailInteractor) {

    val stockDetail : Stock = savedStateHandle.get<Stock>(StockDetailScreen.ALL_STOCK_SCREEN_ARG)!!

    var page : Int = 0
    private var noMoreComment = false

    private val _comments = MutableLiveData<Event<List<StockComment>>>()
    val comments : LiveData<Event<List<StockComment>>> get() = _comments

    init {
        getComments()
    }

    fun putComment(comment : String){
        val request = StockCommentReq(comment)
        callInteractor(interactor.putComment(request, stockDetail.id)) {
            showToast(it.message)
        }
    }

    fun getComments() {
        if (noMoreComment) return
        page ++
        val request = GetStockCommentReq(page)
        callInteractor(interactor.getComments(request, stockDetail.id)) {
            if (it.data.isNotEmpty()){
                _comments.value = Event(it.data)
            }
        }
    }
}