package com.zhonghua.dilebertest.presenter.goodfs;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.zhonghua.dilebertest.delegate.goodfs.GoodsFragmentViewDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.scm.goodfs.IGoodsFragmentScm;
import com.zhonghua.dilebertest.scm.goodfs.GoodsFragmentScm;

public class GoodsFragment extends FragmentPresenter<GoodsFragmentViewDelegate> {
    @Override
    protected Class<GoodsFragmentViewDelegate> getDelegateClass() {
        return GoodsFragmentViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }

    @Override
    public void onClick(View v) {
    }
}
