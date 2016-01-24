package com.zhonghua.newLib.http;

import com.android.volley.*;
import com.android.volley.toolbox.HttpHeaderParser;
import com.zhonghua.newLib.tools.HJson;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shidawei on 16/1/20.
 *
 */
public class GsonRequest<T> extends Request<T> {
    private final Response.Listener<T>listener;
    private Class<T> mClass;

    private Map<String, String> mParams;

    private static Map<String, String> mHeader = new HashMap<String, String>();

    static
    {
        mHeader.put("APP-Key", "");
        mHeader.put("APP-Secret", "");
    }


    public GsonRequest(int method,String url,Map<String, String> params,HttpListener<T> listener,Class<T> tClass){
        super(method,url,listener);
        this.listener=listener;
        mClass = tClass;
        mParams = params;
    }




    /**
     * 数据解析
     * @param response Response from thenetwork  网络请求返回数据
     * @return
     */
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try{
            String parsed = null;
            try {
                parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));

            } catch (UnsupportedEncodingException e) {
                parsed = new String(response.data);
            }

            if (mClass.isAssignableFrom(String.class)) {
                return (Response<T>) Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
            }else{
                T data= HJson.fromJson(parsed, mClass);
                return Response.success(data,HttpHeaderParser.parseCacheHeaders(response));
            }
        }catch (Exception e){
            return Response.error(new ParseError(e));
        }
    }

    /**
     * 数据分发
     * @param response The parsed responsereturned by
     */
    @Override
    protected void deliverResponse(T response){
        listener.onResponse(response);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        //return mHeader;
        return super.getHeaders();
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return mParams;
    }
}