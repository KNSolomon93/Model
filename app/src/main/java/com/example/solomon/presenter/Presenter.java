package com.example.solomon.presenter;

/**
 * Created by Solomon on 2016/11/10.
 */
public interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
