package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import com.tuanlvt.mvp_architecture.data.model.MovieEntry

import com.tuanlvt.mvp_architecture.data.model.Movie
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class ParseDataWithJson {

    @Throws(Exception::class)
    fun getJsonFromUrl(urlString: String?): String? {
        val url = URL(urlString)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.connectTimeout = TIME_OUT
        httpURLConnection.readTimeout = TIME_OUT
        httpURLConnection.requestMethod = METHOD_GET
        httpURLConnection.doOutput = true
        httpURLConnection.connect()

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuilder = StringBuilder()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuilder.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuilder.toString()
    }

    fun parseJsonToData(jsonObject: JSONObject?): MutableList<Movie> {
        val movieList: MutableList<Movie> = ArrayList()
        try {
            val jsonArray = jsonObject?.getJSONArray(MovieEntry.MOVIE)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val movieJson = jsonArray?.getJSONObject(i)
                val movie = parseJsonToObject(movieJson)
                movie?.let { movieList.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movieList
    }

    private fun parseJsonToObject(jsonObjectMovie: JSONObject?): Movie? {
        var movie = Movie()
        try {
            jsonObjectMovie?.let {
                movie = Movie(vote = it.getInt(MovieEntry.VOTE),
                        title = jsonObjectMovie.getString(MovieEntry.TITLE),
                        urlImage = jsonObjectMovie.getString(MovieEntry.URL_IMAGE),
                        originalTitle = jsonObjectMovie.getString(MovieEntry.ORIGINAL_TITLE))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return movie
    }

    companion object {
        private const val TIME_OUT = 15000
        private val METHOD_GET: String? = "GET"
    }
}
