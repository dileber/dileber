package com.zhonghua.dilebertest.presenter;

import android.os.Bundle;
import android.view.View;
import com.zhonghua.dileber.mvp.presenter.ActivityPresenter;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.MainViewDelegate;
import com.zhonghua.dilebertest.scm.IMainScm;
import com.zhonghua.dilebertest.scm.MainScm;

public class MainActivity extends ActivityPresenter<MainViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IMainScm mainSrc = new MainScm();

    }

    @Override
    protected Class<MainViewDelegate> getDelegateClass() {
        return MainViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}