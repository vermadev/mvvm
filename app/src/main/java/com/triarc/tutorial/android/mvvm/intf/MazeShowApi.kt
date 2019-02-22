package com.triarc.tutorial.android.mvvm.intf

import com.triarc.tutorial.android.mvvm.common.EndPoints
import com.triarc.tutorial.android.mvvm.dto.Show
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Devanshu Verma on 18/2/19
 */
interface MazeShowApi {

    @GET(EndPoints.SHOWS)
    fun getShowList(): Observable<List<Show>>
}
