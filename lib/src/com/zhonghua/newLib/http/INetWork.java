package com.zhonghua.newLib.http;

import android.widget.ImageView;
import com.android.volley.Request;

import java.util.Map;

/**
 * Created by shidawei on 16/1/21.
 */
public interface INetWork {

    <T> void netWork(String url,Map<String, String> map,Class<T> clazz,HttpListener<T> listener,Integer type);

    void netWorkForImage(ImageView imageView, String url, int errorImage);

}
