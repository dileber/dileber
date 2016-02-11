package com.zhonghua.dilebertest.delegate;

import com.zhonghua.dileber.mvp.view.AppViewDelegate;
import com.zhonghua.dilebertest.R;

/**
 * Created by  on 16/1/17.
 */
public class SplashViewDelegate extends AppViewDelegate implements ISplashView{


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public void initWidget() {
        super.initWidget();
    }

}