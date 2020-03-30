package com.tuanlvt.mvp_architecture.utils

import com.tuanlvt.mvp_architecture.BuildConfig

object Constant {
    const val BASE_URL = "https://api.themoviedb.org/3/movie/top_rated?"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"
    const val BASE_LANGUAGE = "&language=en-US"
    const val BASE_PAGE = "&page=1"
    const val BASE_API_KEY = "api_key=" + BuildConfig.API_KEY
}
