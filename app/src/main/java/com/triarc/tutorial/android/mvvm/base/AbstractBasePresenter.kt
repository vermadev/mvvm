package com.triarc.tutorial.android.mvvm.base

import com.triarc.tutorial.android.mvvm.intf.Logger
import com.triarc.tutorial.android.mvvm.logger.LoggerImpl
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Devanshu Verma on 18/2/19
 */
abstract class AbstractBasePresenter<View: BaseView>: BasePresenter<View> {

    protected val logger: Logger = LoggerImpl.getLogger(this)

    private var reference: WeakReference<View>? = null

    protected var subscription: CompositeDisposable = CompositeDisposable()

    override fun getView(): View? {
        return reference?.get()
    }

    override fun detachView() {
        reference?.clear()
        subscription.clear()
    }

    override fun attachView(view: View) {
        reference = WeakReference(view)
    }

    protected fun getContext()  = getView()?.getContext()

    protected fun getActivity() = getView()?.getActivity()
}
