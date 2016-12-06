package com.example.solomon.view;

import com.example.solomon.model.MainModelBean;

/**
 * Created by Solomon on 2016/11/10.
 * 处理业务需要哪些方法
 */
public interface MainView {
    void showData(MainModelBean mainModelBean);

    void shwoProgress();

    void higeProgress();

}
