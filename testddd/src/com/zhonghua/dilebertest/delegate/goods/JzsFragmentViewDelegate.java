package com.zhonghua.dilebertest.delegate.goods;

import com.zhonghua.dileber.mvp.view.AppViewDelegate;
import com.zhonghua.dilebertest.R;

/**
 * Created by  on 16/1/17.
 */
public class JzsFragmentViewDelegate extends AppViewDelegate implements IJzsFragmentView{


    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_jzs;
    }


    @Override
    public void initWidget() {
        super.initWidget();
    }

}