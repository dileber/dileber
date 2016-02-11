package com.zhonghua.dilebertest.delegate.goods;

import com.zhonghua.dileber.mvp.view.AppViewDelegate;
import com.zhonghua.dilebertest.R;

/**
 * Created by  on 16/1/17.
 */
public class GoodsFragmentViewDelegate extends AppViewDelegate implements IGoodsFragmentView{


    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_goods;
    }


    @Override
    public void initWidget() {
        super.initWidget();
    }

}