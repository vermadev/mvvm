package com.triarc.tutorial.android.mvvm.intf

import io.reactivex.Observable

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface NetworkHandler {
    fun <Response> request(observable: Observable<Response>): Observable<Response>
}
