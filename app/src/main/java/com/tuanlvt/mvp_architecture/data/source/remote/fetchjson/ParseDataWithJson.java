package com.tuanlvt.mvp_architecture.data.source.remote.fetchjson;

import com.tuanlvt.mvp_architecture.data.model.Movie;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 23/08/2018.
 * tantuan127@gmail.com
 */
public class ParseDataWithJson {

    private static final int TIME_OUT = 15000;
    private static final String METHOD_GET = "GET";

    public String getJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(TIME_OUT);
        httpURLConnection.setReadTimeout(TIME_OUT);
        httpURLConnection.setRequestMethod(METHOD_GET);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
        return stringBuilder.toString();
    }

    public List<Movie> parseJsonToData(JSONObject jsonObject) {
        List<Movie> movieList = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(Movie.MovieEntry.MOVIE);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject movieJson = jsonArray.getJSONObject(i);
                Movie movie = parseJsonToObject(movieJson);
                movieList.add(movie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    private Movie parseJsonToObject(JSONObject jsonObjectMovie) {
        Movie movie = new Movie();
        try {
            movie = new Movie.MovieBuilder().originalTitle(
                    jsonObjectMovie.getString(Movie.MovieEntry.ORIGINAL_TITLE))
                    .title(jsonObjectMovie.getString(Movie.MovieEntry.TITLE))
                    .urlImage(jsonObjectMovie.getString(Movie.MovieEntry.URL_IMAGE))
                    .vote(jsonObjectMovie.getInt(Movie.MovieEntry.VOTE))
                    .build();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
