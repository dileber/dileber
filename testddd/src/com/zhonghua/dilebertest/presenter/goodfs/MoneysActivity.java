package com.zhonghua.dilebertest.presenter.goodfs;

import android.os.Bundle;
import android.view.View;
import com.zhonghua.dileber.mvp.presenter.ActivityPresenter;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.goodfs.MoneysViewDelegate;
import com.zhonghua.dilebertest.scm.goodfs.IMoneysScm;
import com.zhonghua.dilebertest.scm.goodfs.MoneysScm;

public class MoneysActivity extends ActivityPresenter<MoneysViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IMoneysScm moneysSrc = new MoneysScm();

    }

    @Override
    protected Class<MoneysViewDelegate> getDelegateClass() {
        return MoneysViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}