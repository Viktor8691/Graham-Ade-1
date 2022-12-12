package com.sts.investpuzzle.features.friends.friend_profile

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.social.FollowReq
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class FriendProfileViewModel  @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    private val friendProfileInteractor: FriendProfileInteractor,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<FriendProfileInteractor>(schedulerProvider, compositeDisposable, friendProfileInteractor){

    val friendId = savedStateHandle.get<String>(FriendProfileScreen.FRIEND_ID)

    init {

    }

    fun follow(){
        val request = FollowReq(follow = true)
        callInteractor(interactor.follow(request, friendId!!)) {
            showToast("Follow success")
        }
    }
}