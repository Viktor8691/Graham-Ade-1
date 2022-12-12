package com.sts.investpuzzle.features.profile.following

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.constants.Common
import com.sts.investpuzzle.constants.SearchPurpose
import com.sts.investpuzzle.core.data.network.model.user_management.user_info.User
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class FollowingScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    followingScreenInteractor: FollowingScreenInteractor
) : BaseViewModel<FollowingScreenInteractor>(schedulerProvider, compositeDisposable, followingScreenInteractor) {

    private val _followings = MutableLiveData<Event<List<User>>>()
    val followings : LiveData<Event<List<User>>> get() = _followings

    init {
        getFollowings()
    }

    fun getFollowings(){
        callInteractor(interactor.getFollowings(userDetail!!.id)) {
            _followings.value = Event(it.data.followings)
        }
    }
}