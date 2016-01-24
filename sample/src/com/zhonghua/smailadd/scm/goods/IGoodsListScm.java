package com.zhonghua.smailadd.scm.goods;

/**
 * Created by shidawei on 16/1/17.
 */
public interface IGoodsListScm {

    void getGoodsList(String search,Integer order,Integer orderType,Double lat,Double lon,OnGoodsListListener onGoodslistListener);

}
