package com.triarc.tutorial.android.mvvm.repository

import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.dto.Show
import com.triarc.tutorial.android.mvvm.intf.MazeShowApi
import com.triarc.tutorial.android.mvvm.intf.NetworkHandler
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 18/2/19
 */
class ShowListRepository @Inject constructor(private val network: NetworkHandler, private val api: MazeShowApi): ShowList.Repository {

    override fun getTvShowList(): Observable<List<Show>> = network.request(api.getShowList())
}
