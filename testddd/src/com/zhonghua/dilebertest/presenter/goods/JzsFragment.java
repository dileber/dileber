package com.zhonghua.dilebertest.presenter.goods;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.zhonghua.dilebertest.delegate.goods.JzsFragmentViewDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.scm.goods.IJzsFragmentScm;
import com.zhonghua.dilebertest.scm.goods.JzsFragmentScm;

public class JzsFragment extends FragmentPresenter<JzsFragmentViewDelegate> {
    @Override
    protected Class<JzsFragmentViewDelegate> getDelegateClass() {
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
