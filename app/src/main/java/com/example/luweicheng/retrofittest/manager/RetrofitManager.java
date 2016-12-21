package com.example.luweicheng.retrofittest.manager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luweicheng on 2016/12/18.
 */

public class RetrofitManager {
    private RetrofitManager() {
    }

    static final String BASE_URL = "http://news-at.zhihu.com/api/4/news/";
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;

    /**
     * 获取Retrofit管理类的实例对象
     * @return
     */
    public static RetrofitManager getInstance() {

        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (retrofitManager == null) {
                    return new RetrofitManager();
                }
            }
        } else {
            return retrofitManager;
        }
        return null;

    }

    /**
     * 获取Retrofit对象
     * @return
     */
    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }

}
