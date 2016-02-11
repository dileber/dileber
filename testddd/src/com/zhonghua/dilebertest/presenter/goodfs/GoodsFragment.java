package com.zhonghua.dilebertest.presenter.goodfs;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.kymjs.frame.samples.demo1.SimpleDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.goodfsGoodsFragmentViewDelegate;
import com.zhonghua.dilebertest.scm.goodfsIGoodsScm;
import com.zhonghua.dilebertest.scm.goodfsGoodsScm;

public class GoodsFragment extends FragmentPresenter<GoodsFragmentViewDelegate> {
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
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
