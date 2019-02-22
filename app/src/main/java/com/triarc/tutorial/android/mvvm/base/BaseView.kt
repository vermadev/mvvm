package com.triarc.tutorial.android.mvvm.base

import android.content.Context
import android.support.v4.app.FragmentActivity

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface BaseView {
    fun getContext(): Context?
    fun getActivity(): FragmentActivity?
}
