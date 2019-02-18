package com.triarc.tutorial.android.mvvm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Devanshu Verma on 18/2/19
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(baseContext, "All good", Toast.LENGTH_SHORT).show()
    }
}