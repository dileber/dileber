package com.zhonghua.dilebertest.presenter;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.kymjs.frame.samples.demo1.SimpleDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.SmzdesFragmentViewDelegate;
import com.zhonghua.dilebertest.scm.ISmzdesScm;
import com.zhonghua.dilebertest.scm.SmzdesScm;

public class SmzdesFragment extends FragmentPresenter<SmzdesFragmentViewDelegate> {
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
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
