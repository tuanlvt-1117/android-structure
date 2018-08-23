package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson;

import android.os.AsyncTask;
import com.tuanlvt.mvp_architecture.data.model.Movie;
import com.tuanlvt.mvp_architecture.data.source.remote.OnFetchDataJsonListener;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class GetJsonFromUrl extends AsyncTask<String, Void, String> {

    private OnFetchDataJsonListener<Movie> mListener;

    GetJsonFromUrl(OnFetchDataJsonListener<Movie> listener) {
        mListener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        try {
            ParseDataWithJson parseDataWithJson = new ParseDataWithJson();
            data = parseDataWithJson.getJsonFromUrl(strings[0]);
        } catch (Exception e) {
            mListener.onError(e);
        }
        return data;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        if (data != null) {
            try {
                JSONObject jsonObject = new JSONObject(data);
                mListener.onSuccess(new ParseDataWithJson().parseJsonToData(jsonObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
