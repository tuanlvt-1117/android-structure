package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.model.MovieEntry
import org.json.JSONObject

class ParseJson {

    fun movieParseJson(jsonObject: JSONObject): Movie {
        return Movie(vote = jsonObject.getInt(MovieEntry.VOTE),
                title = jsonObject.getString(MovieEntry.TITLE),
                urlImage = jsonObject.getString(MovieEntry.URL_IMAGE),
                originalTitle = jsonObject.getString(MovieEntry.ORIGINAL_TITLE))
    }
}
