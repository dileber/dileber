package com.zhonghua.dilebertest.presenter.goodfs;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.zhonghua.dilebertest.delegate.goodfs.JzsFragmentViewDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.scm.goodfs.IJzsFragmentScm;
import com.zhonghua.dilebertest.scm.goodfs.JzsFragmentScm;

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
