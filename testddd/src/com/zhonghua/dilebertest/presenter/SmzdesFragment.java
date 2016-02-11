package com.zhonghua.dilebertest.presenter;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.zhonghua.dilebertest.delegate.SmzdesFragmentViewDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.scm.ISmzdesFragmentScm;
import com.zhonghua.dilebertest.scm.SmzdesFragmentScm;

public class SmzdesFragment extends FragmentPresenter<SmzdesFragmentViewDelegate> {
    @Override
    protected Class<SmzdesFragmentViewDelegate> getDelegateClass() {
        return SmzdesFragmentViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }

    @Override
    public void onClick(View v) {
    }
}
