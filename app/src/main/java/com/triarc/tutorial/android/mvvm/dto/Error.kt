package com.triarc.tutorial.android.mvvm.dto

/**
 * Created by Devanshu Verma on 18/2/19
 */
class Error(var code: Int? = null, message: String? = null, cause: Throwable? = null): Throwable(message, cause)
