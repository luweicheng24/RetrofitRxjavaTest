package com.example.luweicheng.retrofittest.api;

import com.example.luweicheng.retrofittest.bean.Result;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by luweicheng on 2016/12/18.
 */

public interface GetInterface {
    @GET("least")
    Observable<Result> getNews();
}
