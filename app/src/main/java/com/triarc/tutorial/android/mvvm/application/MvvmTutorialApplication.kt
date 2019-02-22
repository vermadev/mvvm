package com.triarc.tutorial.android.mvvm.application

import android.app.Application
import com.triarc.tutorial.android.mvvm.dependency.*
import com.triarc.tutorial.android.mvvm.intf.Logger
import com.triarc.tutorial.android.mvvm.logger.LoggerImpl

/**
 * Created by Devanshu Verma on 18/2/19
 */
class MvvmTutorialApplication: Application() {

    private val logger: Logger = LoggerImpl.getLogger(this)

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .showListModule(ShowListModule())
            .retrofitServiceModule(RetrofitServiceModule())
            /*.viewModelFactoryModule(ViewModelFactoryModule())*/
            .build()

        logger.debug("Application class created")
    }

    fun getApplicationComponent() = applicationComponent
}
