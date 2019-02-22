package com.triarc.tutorial.android.mvvm.base

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface BasePresenter <View> {
    fun getView(): View?
    fun detachView()
    fun attachView(view: View)
}
