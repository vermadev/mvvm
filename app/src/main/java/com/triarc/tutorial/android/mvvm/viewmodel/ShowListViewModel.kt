package com.triarc.tutorial.android.mvvm.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.triarc.tutorial.android.mvvm.common.ErrorCode
import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.dto.Error
import com.triarc.tutorial.android.mvvm.dto.Show
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Devanshu Verma on 31/1/19
 */
class ShowListViewModel(private val model: ShowList.Model): ViewModel(), ShowList.ViewModel {

    private var subscription: CompositeDisposable = CompositeDisposable()

    private var error:    MutableLiveData<String>     = MutableLiveData()
    private var shows:    MutableLiveData<List<Show>> = MutableLiveData()
    private var progress: MutableLiveData<Boolean>    = MutableLiveData()

    override fun getError(): MutableLiveData<String> = error

    override fun getTvShowList(): MutableLiveData<List<Show>> {
        progress.value = true
        subscription.add(model.getTvShowList().subscribe({shows ->
            progress.value = false
            this.shows.value = shows
        }, {
            progress.value = false

            val error = it as Error
            val message = when(error.code) {
                ErrorCode.NULL_RESPONSE -> "List is empty"
                ErrorCode.INTERNET_NOT_AVAILABLE -> "Internet not available"
                else -> "Something went wrong"
            }
            this.error.value = message
        }))
        return shows
    }

    override fun getProgressBar(): MutableLiveData<Boolean> = progress
}
