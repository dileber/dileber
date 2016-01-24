package com.zhonghua.dileber.mvp.scm;

import android.widget.ImageView;
import com.android.volley.Request;
import com.zhonghua.dileber.http.HttpListener;
import com.zhonghua.dileber.http.HttpManager;
import com.zhonghua.dileber.http.INetWork;

import java.util.Map;

/**
 * Created by shidawei on 16/1/17.
 */
public class Scm implements INetWork {

    protected final static Integer TYPE_GET = 0;

    protected final static Integer TYPE_POST = 1;

    @Override
    public <T> void netWork(String url, Map<String, String> map, Class<T> clazz, HttpListener<T> listener, Integer type) {
        int method = Request.Method.GET;
        if(type==null||type.equals(TYPE_GET)){
            method =  Request.Method.GET;
        }else if(type.equals(TYPE_POST)){
            method =  Request.Method.POST;
        }
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.requestGson(method,url,map,listener,clazz);
    }

    @Override
    public void netWorkForImage(ImageView imageView, String url, int errorImage) {
        HttpManager httpManager = HttpManager.getInstance();
        httpManager.requestImage(imageView,url,errorImage);
    }


}
