package com.sts.investpuzzle.features.profile.followers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.constants.Common
import com.sts.investpuzzle.constants.SearchPurpose
import com.sts.investpuzzle.core.data.network.model.social.GetFollowersReq
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class FollowerScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    followerScreenInteractor: FollowerScreenInteractor
) : BaseViewModel<FollowerScreenInteractor>(schedulerProvider, compositeDisposable, followerScreenInteractor){

    var page = 0
    var limit = 20
    var noStockMore = false
    var isFirstSearch = false
    var request = GetFollowersReq()

    private val _followers = MutableLiveData<Event<List<User>>>()
    val followers : LiveData<Event<List<User>>> get() = _followers

    init {
        Common.searchPurpose = SearchPurpose.FOLLOWERS
        getFollowers("")
    }

    fun getFollowers(query : String){
        if (noStockMore) return
        if (isFirstSearch) page = 0
        page++
        request = GetFollowersReq(page = page, keyword = query)

        if (request.keyword.isNotEmpty() && Common.searchPurpose != SearchPurpose.FOLLOWERS) return

        request = GetFollowersReq(page = page, limit = limit)
        callInteractor(interactor.getFollowers(request, userDetail!!.id)) {
            _followers.value = Event(it.data.followers)
            if (it.data.followers.size < 20) noStockMore = true
        }
    }
}