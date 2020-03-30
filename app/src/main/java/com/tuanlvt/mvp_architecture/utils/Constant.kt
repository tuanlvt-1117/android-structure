package com.tuanlvt.mvp_architecture.utils

import com.tuanlvt.mvp_architecture.BuildConfig

object Constant {
    val BASE_URL: String? = "https://api.themoviedb.org/3/movie/top_rated?"
    val BASE_URL_IMAGE: String? = "https://image.tmdb.org/t/p/w500"
    val BASE_LANGUAGE: String? = "&language=en-US"
    val BASE_PAGE: String? = "&page=1"
    val BASE_API_KEY: String? = "api_key=" + BuildConfig.API_KEY
}
