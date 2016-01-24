package com.zhonghua.dileber.http;

import android.util.Patterns;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.Map;

/**
 * Created by shidawei on 16/1/17.
 */
public class HttpManager {

    private static volatile HttpManager mInstance;

    public static HttpManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                if (mInstance == null)
                    mInstance = new HttpManager();
            }
        }
        return mInstance;
    }

    public static synchronized void clearResource() {
        if (mInstance != null) {
            synchronized (HttpManager.class) {
                if (mInstance != null)
                    mInstance.clearVolleyResource();
                    mInstance = null;
            }
        }
    }

    public void clearVolleyResource() {
        // 关闭队列
        if (mRequestQueue != null)
            mRequestQueue.stop();
    }

    public static boolean isValidUrl(String url) {
        try {
            return Patterns.WEB_URL.matcher(url).matches();
        } catch (Exception e) {
            // 解析错误，非正常Url
            e.printStackTrace();
        }
        return false;
    }

    private RequestQueue mRequestQueue;

    private HttpManager() {

        //mRequestQueue = Volley.newRequestQueue(SApplication.getAppContext());

        mRequestQueue = new RequestQueue(CacheConfig.getDiskCache(), new SBaseNetWork(new HurlStack()));
        mRequestQueue.start();
    }

    public<T>void addRequestQueue(Request<T> request) {

        mRequestQueue.add(request);

    }


    public<T> void requestGson(int method,final String url,Map<String, String> map, final HttpListener<T> httpListener,Class<T> clazz) {
        // url判断
        if (!isValidUrl(url)) {
            httpListener.onFailure(new VolleyError("ERROR: URL IS NOT EXITENT"));
            return;
        }
        GsonRequest<T> gsonRequest = new GsonRequest<T>(method,url,map,httpListener,clazz);
        addRequestQueue(gsonRequest);
    }

    private ImageLoader mNetworkImageLoader;

    private ImageLoader getNetworkImageLoader() {
        if (mNetworkImageLoader == null) {
            // 开启内存和本地二级缓存
            mNetworkImageLoader = new ImageLoader(mRequestQueue, CacheConfig.getBitmapCache());
        }
        return mNetworkImageLoader;
    }

    // 获取图片
    public void requestImage(final ImageView imageView, final String url, final int errorImage) {
        if (!isValidUrl(url)) {
            imageView.setImageResource(errorImage);
            return;
        }
        getNetworkImageLoader().get(url, new HttpImage(imageView, errorImage));
    }

    public boolean getCachedImages(NetworkImageView imageView, String url) {
        if (!isValidUrl(url)) {
            return false;
        }

        imageView.setImageUrl(url, getNetworkImageLoader());
        return true;
    }

    public boolean containImageCache(String url) {
        return getNetworkImageLoader().isCached(url, 0, 0);
    }



}
