package com.zhonghua.dilebertest.delegate;

import com.zhonghua.dileber.mvp.view.AppViewDelegate;
import com.zhonghua.dilebertest.R;

/**
 * Created by  on 16/1/17.
 */
public class SmzdesFragmentViewDelegate extends AppViewDelegate implements ISmzdesFragmentView{


    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_smzdes;
    }


    @Override
    public void initWidget() {
        super.initWidget();
    }

}