package com.tuanlvt.mvp_architecture.data.model

data class Movie(
        val vote: Int = 0,
        var title: String = "",
        var urlImage: String = "",
        var originalTitle: String = ""
)

object MovieEntry {
    const val MOVIE = "results"
    const val VOTE = "vote_average"
    const val TITLE = "title"
    const val URL_IMAGE = "poster_path"
    const val ORIGINAL_TITLE = "original_title"
}
