package com.zhonghua.newLib.mvp.scm;


import com.zhonghua.newLib.mvp.model.SModel;

/**
 * Created by shidawei on 16/1/22.
 */
public interface INetListener <T> {

    void before();

    void success(T model);

    void failed();

}
