package com.tuanlvt.mvp_architecture.utils.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * Created by FRAMGIA\le.vu.tan.tuan on 28/08/2018.
 * tantuan127@gmail.com
 */
public interface BaseSchedulerProvider {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();
}
