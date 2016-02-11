package com.zhonghua.dilebertest.presenter.goods;

import android.view.View;
import com.zhonghua.dileber.mvp.presenter.FragmentPresenter;
import com.kymjs.frame.samples.demo1.SimpleDelegate;
import com.zhonghua.dilebertest.R;
import com.zhonghua.dilebertest.delegate.goodsGoodsFragmentViewDelegate;
import com.zhonghua.dilebertest.scm.goodsIGoodsScm;
import com.zhonghua.dilebertest.scm.goodsGoodsScm;

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
