package com.sts.investpuzzle.features.news.news_page

import com.sts.investpuzzle.base.BaseViewModel
import com.sts.investpuzzle.utils.rx.SchedulerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    newsInteractor: NewsInteractor
) : BaseViewModel<NewsInteractor>(schedulerProvider, compositeDisposable, newsInteractor) {
}