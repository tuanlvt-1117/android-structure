package com.tuanlvt.mvp_architecture.utils.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tuanlvt.mvp_architecture.utils.Constant

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
            .load(Constant.BASE_URL_IMAGE + url)
            .into(this)
}

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
            .load(Constant.BASE_URL_IMAGE + url)
            .circleCrop()
            .into(this)
}
