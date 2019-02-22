package com.triarc.tutorial.android.mvvm.contract

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import com.triarc.tutorial.android.mvvm.base.BasePresenter
import com.triarc.tutorial.android.mvvm.base.BaseView
import com.triarc.tutorial.android.mvvm.dto.Show
import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface ShowList {

    interface View: BaseView {
        fun onBindError(error: MutableLiveData<String>?)
        fun onBindAdapter(shows: MutableLiveData<List<Show>>?)
        fun onBindProgress(progress: MutableLiveData<Boolean>?)
        fun onInitialiseAdapter()
        fun onInitialiseListener()
        fun onInitialiseListLayout()
    }

    interface Model {
        fun getTvShowList(): Observable<List<Show>>
    }

    interface Presenter: BasePresenter<View> {
        fun bindViewModel()
        fun requestShowList()
    }

    interface ViewModel {
        fun getError(): MutableLiveData<String>
        fun getTvShowList(): MutableLiveData<List<Show>>
        fun getProgressBar(): MutableLiveData<Boolean>
    }

    interface Repository {
        fun getTvShowList(): Observable<List<Show>>
    }
}