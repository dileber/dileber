package com.zhonghua.dilebertest.presenter.goodfs;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.kymjs.frame.samples.demo1.SimpleDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.goodfsJzsFragmentViewDelegate;
import com.zhonghua.dilebertest.scm.goodfsIJzsScm;
import com.zhonghua.dilebertest.scm.goodfsJzsScm;

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
