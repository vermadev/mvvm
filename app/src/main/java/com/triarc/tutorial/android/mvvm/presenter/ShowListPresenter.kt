package com.triarc.tutorial.android.mvvm.presenter

import com.triarc.tutorial.android.mvvm.base.AbstractBasePresenter
import com.triarc.tutorial.android.mvvm.contract.ShowList

/**
 * Created by Devanshu Verma on 18/2/19
 */
class ShowListPresenter(private var viewModel: ShowList.ViewModel? = null): AbstractBasePresenter<ShowList.View>(), ShowList.Presenter {

    override fun attachView(view: ShowList.View) {
        super.attachView(view)
        view.onInitialiseListLayout()
        view.onInitialiseAdapter()
        view.onInitialiseListener()
    }

    override fun bindViewModel() {
        getView()?.onBindError(viewModel?.getError())
        getView()?.onBindProgress(viewModel?.getProgressBar())
        getView()?.onBindAdapter(viewModel?.getTvShowList())
    }

    override fun requestShowList() {
        viewModel?.getTvShowList()
    }
}
