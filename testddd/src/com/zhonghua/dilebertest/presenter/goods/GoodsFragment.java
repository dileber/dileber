package com.zhonghua.dilebertest.presenter.goods;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.zhonghua.dilebertest.delegate.goods.GoodsFragmentViewDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.scm.goods.IGoodsFragmentScm;
import com.zhonghua.dilebertest.scm.goods.GoodsFragmentScm;

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
