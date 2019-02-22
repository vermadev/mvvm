package com.triarc.tutorial.android.mvvm.model

import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.dto.Show
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 18/2/19
 */
class ShowListModel @Inject constructor(private val repository: ShowList.Repository): ShowList.Model {

    override fun getTvShowList(): Observable<List<Show>> = repository.getTvShowList()
}
