package com.tuanlvt.mvp_architecture.data.source.remote.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.tuanlvt.mvp_architecture.utils.Constant.BASE_URL;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 24/08/2018.
 * tantuan127@gmail.com
 */
public class RetrofitBuilder {

    private static final int TIME_OUT = 15000;
    private static Retrofit sRetrofit;

    public static Retrofit getsRetrofit() {
        if (sRetrofit == null) {
            OkHttpClient okHttpClient =
                    new OkHttpClient.Builder().readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                            .retryOnConnectionFailure(true)
                            .build();

            Gson gson = new GsonBuilder().setLenient().create();
            sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
