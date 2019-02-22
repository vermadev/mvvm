package com.triarc.tutorial.android.mvvm.dependency

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Devanshu Verma on 18/2/19
 */
@Module
class ContextModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideBaseContext(): Context = application.baseContext

    @Provides
    @Singleton
    fun provideApplication(): Application = application
}
