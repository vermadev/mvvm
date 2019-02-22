package com.triarc.tutorial.android.mvvm.dependency

import android.arch.lifecycle.ViewModelProviders
import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.presenter.ShowListPresenter
import com.triarc.tutorial.android.mvvm.view.ShowListFragment
import com.triarc.tutorial.android.mvvm.viewmodel.ShowListViewModel
import com.triarc.tutorial.android.mvvm.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 19/2/19
 */
class PresenterInjector @Inject constructor(private val factory: ViewModelFactory) {

    fun inject(fragment: ShowListFragment): ShowList.Presenter {
        return ShowListPresenter(ViewModelProviders.of(fragment, factory).get(ShowListViewModel::class.java))
    }
}
