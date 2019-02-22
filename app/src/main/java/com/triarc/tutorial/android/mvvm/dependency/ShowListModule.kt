package com.triarc.tutorial.android.mvvm.dependency

import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.intf.MazeShowApi
import com.triarc.tutorial.android.mvvm.model.ShowListModel
import com.triarc.tutorial.android.mvvm.network.NetworkHandlerImpl
import com.triarc.tutorial.android.mvvm.repository.ShowListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 18/2/19
 */
@Module
class ShowListModule {

    @Provides
    @Singleton
    fun provideTvShowModel(repository: ShowList.Repository): ShowList.Model = ShowListModel(repository)

    @Provides
    @Singleton
    fun provideTvShowRepository(network: NetworkHandlerImpl, api: MazeShowApi): ShowList.Repository = ShowListRepository(network, api)
}
