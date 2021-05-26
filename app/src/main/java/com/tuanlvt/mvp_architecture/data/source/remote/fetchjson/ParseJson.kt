package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.model.MovieEntry
import org.json.JSONObject

class ParseJson {

    fun movieParseJson(jsonObject: JSONObject) = Movie().apply {
        jsonObject.let {
            vote = it.getInt(MovieEntry.VOTE)
            title = it.getString(MovieEntry.TITLE)
            urlImage = it.getString(MovieEntry.URL_IMAGE)
            originalTitle = it.getString(MovieEntry.ORIGINAL_TITLE)
            voteCount = it.getInt(MovieEntry.VOTE_COUNT)
            backDropImage = it.getString(MovieEntry.BACKDROP_IMAGE)
            overView = it.getString(MovieEntry.OVERVIEW)
        }
    }
}
