package com.example.solomon.presenter;

import com.example.solomon.model.MainModelBean;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Solomon on 2016/11/10.
 * 此接口作用是链接model
 */
public interface IMainPresenter {
    void loadDataSuccess(MainModelBean mainModelBean);

    void loadDataFailure(int statusCode, Header[] headers, String responseString, Throwable throwable);
}
