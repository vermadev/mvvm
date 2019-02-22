package com.triarc.tutorial.android.mvvm.dependency

import com.triarc.tutorial.android.mvvm.view.ShowListFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 18/2/19
 */
@Singleton
@Component(modules = [ContextModule::class, ShowListModule::class, RetrofitServiceModule::class/*, ViewModelFactoryModule::class*/])
interface ApplicationComponent {

    fun inject(target: ShowListFragment)
}
