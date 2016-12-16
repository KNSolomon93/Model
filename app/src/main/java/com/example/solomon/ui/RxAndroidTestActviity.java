package com.example.solomon.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.solomon.model.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by Solomon on 2016/12/16.
 */
public class RxAndroidTestActviity extends Activity {
    private static final String tag = "RxAndroidTestActviity";
    @Bind(R.id.text1)
    TextView text1;
    @Bind(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxjava_layout);
        ButterKnife.bind(this);
        initView1();
        initView2();
    }


    private void initView1() {
        /**
         * 创建观察者 事件触发的时候就将有怎样的行为
         * 1.Observer
         * 2.Subscriber
         */

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                Log.d(tag, "item :" + s);
            }

            @Override
            public void onCompleted() {
                Log.d(tag, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "onError");
            }


        };


        Subscriber<String> subscriber = new Subscriber<String>() {


            @Override
            public void onNext(String s) {
                Log.d(tag, "item :" + s);
            }

            @Override
            public void onCompleted() {
                Log.d(tag, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "onError");
            }
        };


        /**
         * 创建被观察者
         * Observable
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });

    }

    private void initView2() {


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
