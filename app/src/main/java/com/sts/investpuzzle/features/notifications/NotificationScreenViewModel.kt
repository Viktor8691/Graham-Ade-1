package com.sts.investpuzzle.features.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.core.data.network.model.notification.GetNotiReq
import com.sts.investpuzzle.core.data.network.model.notification.Notification
import com.sts.investpuzzle.core.data.network.model.social.AcceptFollowReq
import com.sts.investpuzzle.utils.Event
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class NotificationScreenViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    notificationScreenInteractor: NotificationScreenInteractor,
) : BaseViewModel<NotificationScreenInteractor>(schedulerProvider, compositeDisposable, notificationScreenInteractor){

    private val _notifications = MutableLiveData<Event<List<Notification>>>()
    val notifications : LiveData<Event<List<Notification>>> get() = _notifications

    init {
        getNoti()
    }

    fun getNoti(){
        val request = GetNotiReq(1, 20, "", -1)
        callInteractor(interactor.getNoti(request)) {
            _notifications.value = Event(it.data.notifications)
        }
    }

    fun acceptOrRejectFollow(userId : String, isAccept : Boolean){
        val request = AcceptFollowReq(isAccept)
        callInteractor(interactor.acceptFollow(request, userId)) {
            if (isAccept){
                showToast("You accepted follow request")
            }else{
                showToast("You rejected follow request")
            }
        }
    }
}