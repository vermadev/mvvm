package com.triarc.tutorial.android.mvvm.intf

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface Logger {
    fun info(logMsg: String)
    fun error(logMsg: String)
    fun debug(logMsg: String)
}
