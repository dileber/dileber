package com.zhonghua.dilebertest.presenter.goods;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.kymjs.frame.samples.demo1.SimpleDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.goodsJzsFragmentViewDelegate;
import com.zhonghua.dilebertest.scm.goodsIJzsScm;
import com.zhonghua.dilebertest.scm.goodsJzsScm;

public class JzsFragment extends FragmentPresenter<JzsFragmentViewDelegate> {
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return JzsFragmentViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }

    @Override
    public void onClick(View v) {
    }
}
