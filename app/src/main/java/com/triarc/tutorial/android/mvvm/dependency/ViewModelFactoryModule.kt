package com.triarc.tutorial.android.mvvm.dependency

import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.viewmodel.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 19/2/19
 */
@Module
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(model: ShowList.Model) = ViewModelFactory(model)
}
