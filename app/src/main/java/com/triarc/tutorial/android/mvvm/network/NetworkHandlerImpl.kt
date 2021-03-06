package com.triarc.tutorial.android.mvvm.network

import android.content.Context
import com.triarc.tutorial.android.mvvm.common.ErrorCode
import com.triarc.tutorial.android.mvvm.dto.Error
import com.triarc.tutorial.android.mvvm.intf.NetworkHandler
import com.triarc.tutorial.android.mvvm.utility.Utils
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 18/2/19
 */
class NetworkHandlerImpl(private val context: Context, private val observer: Scheduler, private val scheduler: Scheduler) : NetworkHandler {

    @Inject constructor(context: Context): this(context, AndroidSchedulers.mainThread(), Schedulers.io())

    override fun <Response> request(observable: Observable<Response>): Observable<Response> {
        return Observable.create { subscriber ->
            if(Utils.isInternetAvailable(context)) {
                observable.subscribeOn(scheduler).observeOn(observer).subscribe({ response ->
                    if(response != null) {
                        subscriber.onNext(response)
                    } else {
                        subscriber.onError(Error(ErrorCode.NULL_RESPONSE))
                    }
                }, {
                    subscriber.onError(Error(ErrorCode.SOMETHING_WENT_WRONG))
                })
            } else {
                subscriber.onError(Error(ErrorCode.INTERNET_NOT_AVAILABLE))
            }
        }
    }
}
