package com.zhonghua.smailadd.model;

import com.zhonghua.newLib.mvp.model.SModel;

/**
 * Created by shidawei on 16/1/17.
 */
public class GoodsModel extends SModel{

    private Integer error_code;
    private String reason;

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
