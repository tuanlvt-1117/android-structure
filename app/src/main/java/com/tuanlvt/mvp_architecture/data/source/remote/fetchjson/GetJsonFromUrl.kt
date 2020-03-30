package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import android.os.AsyncTask
import com.tuanlvt.mvp_architecture.data.model.Movie
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener
import org.json.JSONException
import org.json.JSONObject

class GetJsonFromUrl constructor(private val listener: OnFetchDataJsonListener<Movie>) :
        AsyncTask<String?, Void?, String?>() {

    override fun doInBackground(vararg strings: String?): String? {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(strings[0]).toString()
        } catch (e: Exception) {
            listener.onError(e)
        }
        return data
    }

    override fun onPostExecute(data: String?) {
        super.onPostExecute(data)
        try {
            data?.let {
                val jsonObject = JSONObject(it)
                listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
