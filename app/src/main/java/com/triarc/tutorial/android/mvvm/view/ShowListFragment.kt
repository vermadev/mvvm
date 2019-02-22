package com.triarc.tutorial.android.mvvm.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.triarc.tutorial.android.mvvm.MainActivity
import com.triarc.tutorial.android.mvvm.R
import com.triarc.tutorial.android.mvvm.adapter.ShowListAdapter
import com.triarc.tutorial.android.mvvm.application.MvvmTutorialApplication
import com.triarc.tutorial.android.mvvm.contract.ShowList
import com.triarc.tutorial.android.mvvm.dependency.PresenterInjector
import com.triarc.tutorial.android.mvvm.dto.Show
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

/**
 * Created by Devanshu Verma on 18/2/19
 */
class ShowListFragment: Fragment(), ShowList.View {

    private var rootView: View? = null

    private var showListAdapter: ShowListAdapter? = null

    private var recyclerLayoutManager: RecyclerView.LayoutManager? = null

    @Inject
    lateinit var injector: PresenterInjector

    lateinit var presenter: ShowList.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ((activity as? MainActivity)?.application as? MvvmTutorialApplication)?.getApplicationComponent()?.inject(this)

        presenter = injector.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        rootView = inflater.inflate(R.layout.fragment_movie_list, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter.attachView(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.bindViewModel()
    }

    override fun onResume() {
        super.onResume()

        presenter.requestShowList()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.detachView()
    }

    override fun onBindError(error: MutableLiveData<String>?) {
        error?.observe(this, object : Observer<String> {
            override fun onChanged(message: String?) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onBindAdapter(shows: MutableLiveData<List<Show>>?) {
        shows?.observe(this, object : Observer<List<Show>> {
            override fun onChanged(list: List<Show>?) {
                showListAdapter?.updateList(list)
            }
        })
    }

    override fun onBindProgress(progress: MutableLiveData<Boolean>?) {
        progress?.observe(this, object : Observer<Boolean> {
            override fun onChanged(visibility: Boolean?) {
                swipe_container.isRefreshing = visibility ?: false
            }
        })
    }

    override fun onInitialiseAdapter() {
        showListAdapter = ShowListAdapter(context)
        recycler_list_view.adapter = showListAdapter
    }

    override fun onInitialiseListener() {
        swipe_container.setOnRefreshListener {
            presenter.requestShowList()
        }
    }

    override fun onInitialiseListLayout() {
        recyclerLayoutManager = LinearLayoutManager(context)
        recycler_list_view.layoutManager = recyclerLayoutManager
    }
}
