package com.zhonghua.dilebertest.presenter;

import android.os.Bundle;
import android.view.View;
import com.zhonghua.dileber.mvp.presenter.ActivityPresenter;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.SplashViewDelegate;
import com.zhonghua.dilebertest.scm.ISplashScm;
import com.zhonghua.dilebertest.scm.SplashScm;

public class SplashActivity extends ActivityPresenter<SplashViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ISplashScm splashSrc = new SplashScm();

    }

    @Override
    protected Class<SplashViewDelegate> getDelegateClass() {
        return SplashViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}