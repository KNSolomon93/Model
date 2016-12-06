package com.example.solomon.presenter;

import com.example.solomon.model.MainModel;
import com.example.solomon.model.MainModelBean;
import com.example.solomon.view.MainView;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Solomon on 2016/11/10.
 */
public class MainPresenter implements Presenter<MainView>, IMainPresenter {
    private MainView mMainView;
    private MainModel mMainModel;

    public MainPresenter(MainView view) {
        attachView(view);
        mMainModel = new MainModel(this);
    }

    public void loadData(){
        mMainView.shwoProgress();
        mMainModel.loadData();
    }


    @Override
    public void loadDataSuccess(MainModelBean mainModelBean) {
        mMainView.showData(mainModelBean);
        mMainView.higeProgress();
    }

    @Override
    public void loadDataFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        mMainView.higeProgress();
    }

    @Override
    public void attachView(MainView view) {
        this.mMainView = view;
    }

    @Override
    public void detachView() {
        this.mMainView = null;
    }
}
