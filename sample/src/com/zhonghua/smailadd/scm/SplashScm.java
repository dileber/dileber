package com.zhonghua.smailadd.scm;

import android.widget.ImageView;
import com.zhonghua.dileber.mvp.scm.Scm;
import com.zhonghua.smailadd.R;

/**
 * Created by shidawei on 16/1/17.
 */
public class SplashScm extends Scm implements ISplashScm {
    @Override
    public void showSplashResourceImage(ImageView imageView) {
        netWorkForImage(imageView,"https://c1.staticflickr.com/8/7516/16112631626_91e4c54e1e_n.jpg",R.drawable.splash);
    }

//    @Override
//    public int showSplashResourceImage() {
//        return R.drawable.splash;
//    }





}
