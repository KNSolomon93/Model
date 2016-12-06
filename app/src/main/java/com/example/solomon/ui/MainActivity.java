package com.example.solomon.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.solomon.Tool.ModelBluerTransformation;
import com.example.solomon.model.MainModelBean;
import com.example.solomon.model.R;
import com.example.solomon.presenter.MainPresenter;
import com.example.solomon.view.MainView;
import com.squareup.picasso.Picasso;

public class MainActivity extends Activity implements MainView {
    private ProgressBar mProgressBar;
    private TextView text;
    private ImageView imageView;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    StackBlur.blur()
        initView();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.text);
        imageView= (ImageView) findViewById(R.id.imageView);
        mProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        mMainPresenter=new MainPresenter(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMainPresenter.loadData();
            }
        }, 2000);
        String url = "http://image-test.aircoach.cn/media/940d07f9ce5d56520a8c8dee3dda8d5d.jpg";
        Picasso.with(this)
                .load(url)
                .transform(new ModelBluerTransformation(70))
                .into(imageView);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showData(MainModelBean mainModelBean) {
        String showData =  mainModelBean.getCity()
                + mainModelBean.getWd()
                +mainModelBean.getWs()
                +mainModelBean.getTime();
        text.setText(showData);
    }

    @Override
    public void shwoProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void higeProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

}

