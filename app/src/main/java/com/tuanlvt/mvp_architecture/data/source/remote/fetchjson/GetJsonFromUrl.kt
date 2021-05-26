package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson

import android.os.Handler
import android.os.Looper
import com.tuanlvt.mvp_architecture.data.source.remote.OnDataResultListener
import org.json.JSONObject
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class GetJsonFromUrl<T> constructor(private val listener: OnDataResultListener<T>,
                                    private val urlString: String,
                                    private val keyEntity: String) {

    private val executor: Executor = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())
    private var exception: Exception? = null
    private var data: T? = null

    init {
        callAPI()
    }

    @Suppress("UNCHECKED_CAST")
    private fun callAPI() {
        executor.execute {
            val parseDataWithJson = ParseDataWithJson()
            val jsonObject = JSONObject(parseDataWithJson.getJsonFromUrl(urlString))
            data = ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T
            handler.post {
                try {
                    data?.let { listener.onSuccess(it) }
                } catch (e: Exception) {
                    listener.onError(exception)
                }
            }
        }
    }
}
