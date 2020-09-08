package com.github.metnyov.party.presentation.view.extensions

import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.github.metnyov.party.R
import com.github.metnyov.party.data.GlideApp

fun ImageView.load(
    url: String,
    placeholderRes: Int = R.drawable.img_placeholder_circle,
    circleCrop: Boolean = true
) {
    GlideApp.with(this)
        .load(url)
        .transition(
            DrawableTransitionOptions.with(
                DrawableCrossFadeFactory.Builder(300)
                    .setCrossFadeEnabled(true)
                    .build()
            )
        )
        .placeholder(placeholderRes)
        .apply {
            if (circleCrop) {
                circleCrop()
            }
        }
        .into(this)
}