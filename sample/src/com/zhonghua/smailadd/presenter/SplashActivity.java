package com.zhonghua.smailadd.presenter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.zhonghua.dileber.mvp.presenter.ActivityPresenter;
import com.zhonghua.dileber.tools.HJson;
import com.zhonghua.dileber.tools.SLog;
import com.zhonghua.dileber.tools.annotation.CloseStatusBar;
import com.zhonghua.dileber.tools.annotation.CloseTitle;
import com.zhonghua.smailadd.R;
import com.zhonghua.smailadd.delegate.SplashViewDelegate;
import com.zhonghua.smailadd.model.GoodsModel;
import com.zhonghua.smailadd.scm.ISplashScm;
import com.zhonghua.smailadd.scm.SplashScm;
import com.zhonghua.smailadd.scm.goods.GoodsListScm;
import com.zhonghua.smailadd.scm.goods.OnGoodsListListener;

@CloseStatusBar
@CloseTitle
public class SplashActivity extends ActivityPresenter<SplashViewDelegate>  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ISplashScm imageSrc = new SplashScm();
        imageSrc.showSplashResourceImage((ImageView) viewDelegate.get(R.id.imageView));

        GoodsListScm goodsListScm = new GoodsListScm();
        goodsListScm.getGoodsList(null, null, null, null, null, new OnGoodsListListener<GoodsModel>() {
            @Override
            public void before() {
                viewDelegate.loading();
            }

            @Override
            public void success(GoodsModel model) {
                String ss = HJson.toJson(model);
                SLog.i(">>>>>>",ss);
                viewDelegate.loadDialogDismiss();
            }

            @Override
            public void failed() {
                viewDelegate.loadDialogDismiss();
            }
        });



    }

    @Override
    protected Class<SplashViewDelegate> getDelegateClass() {
        return SplashViewDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
    }


    @Override
    public void onClick(View view) {

    }
}
