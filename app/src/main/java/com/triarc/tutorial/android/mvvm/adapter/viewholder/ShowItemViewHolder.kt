package com.triarc.tutorial.android.mvvm.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.triarc.tutorial.android.mvvm.R
import com.triarc.tutorial.android.mvvm.base.AbstractBaseViewHolder

/**
 * Created by Devanshu Verma on 18/2/19
 */
class ShowItemViewHolder(view: View): AbstractBaseViewHolder(view){

    val image: ImageView = view.findViewById(R.id.cover_image)

    val year:     TextView = view.findViewById(R.id.year)
    val genre:    TextView = view.findViewById(R.id.genre)
    val title:    TextView = view.findViewById(R.id.title)
    val rating:   TextView = view.findViewById(R.id.rating)
    val subTitle: TextView = view.findViewById(R.id.subtitle)
}
