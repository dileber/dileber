package com.zhonghua.smailadd.scm.goods;

import com.android.volley.VolleyError;
import com.zhonghua.dileber.http.HttpListener;
import com.zhonghua.dileber.mvp.scm.Scm;
import com.zhonghua.dileber.tools.SLog;
import com.zhonghua.smailadd.model.GoodsModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shidawei on 16/1/17.
 */
public class GoodsListScm extends Scm implements IGoodsListScm {
    @Override
    public void getGoodsList(String search, Integer order, Integer orderType, Double lat, Double lon, final OnGoodsListListener onGoodslistListener) {
        onGoodslistListener.before();
        Map<String,Object> map = new HashMap<String,Object>();
        netWork("http://api.avatardata.cn/Constellation/Query", null, GoodsModel.class, new HttpListener<GoodsModel>(){

            @Override
            protected void onSuccess(GoodsModel response) {
                onGoodslistListener.success(response);
            }

            @Override
            protected void onFailure(VolleyError error) {
                SLog.e("ERROR_MESSAGE",error.getMessage());
                onGoodslistListener.failed();
            }
        } , TYPE_POST);
    }
}
