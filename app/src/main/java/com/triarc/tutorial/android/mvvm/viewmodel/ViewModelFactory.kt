package com.triarc.tutorial.android.mvvm.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.triarc.tutorial.android.mvvm.contract.ShowList
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 31/1/19
 */
@Singleton
class ViewModelFactory @Inject constructor(private val model: ShowList.Model): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ShowListViewModel::class.java))
            ShowListViewModel(model) as T
        else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
