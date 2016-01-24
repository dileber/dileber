package com.zhonghua.smailadd.app;

import com.zhonghua.dileber.app.SApplication;

/**
 * Created by shidawei on 16/1/21.
 */
public class SmailApplication extends SApplication{

    @Override
    public void onCreate() {
        super.onCreate();
        buglog(Configer.BUG_STATIC,Configer.BUG_NAME);
    }
}
