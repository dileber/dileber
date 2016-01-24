package com.zhonghua.smailadd.delegate;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zhonghua.dileber.mvp.view.AppViewDelegate;
import com.zhonghua.smailadd.R;

/**
 * Created by shidawei on 16/1/17.
 */
public class SplashViewDelegate extends AppViewDelegate implements ISplashView{


    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    LinearLayout splash_layout;
    ImageView imageView;

    @Override
    public void initWidget() {
        super.initWidget();
        splash_layout = bindView(R.id.splash_layout);
        imageView = bindView(R.id.imageView);
    }

}
