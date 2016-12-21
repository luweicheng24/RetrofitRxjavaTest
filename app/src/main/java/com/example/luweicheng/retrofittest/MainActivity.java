package com.example.luweicheng.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.luweicheng.retrofittest.api.GetInterface;
import com.example.luweicheng.retrofittest.bean.Result;
import com.example.luweicheng.retrofittest.manager.RetrofitManager;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Subscriber<Result> subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.but_retrofit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetInterface getInterface = RetrofitManager.getInstance().getRetrofit().create(GetInterface.class);
                getInterface.getNews()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber);

            }
        });
         subscriber = new Subscriber<Result>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getMessage().toString() );

            }

            @Override
            public void onNext(Result result) {
                Log.e(TAG, "onNext: "+result.getStories().toString() );

            }
        };



    }


}
