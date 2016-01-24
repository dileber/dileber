package com.zhonghua.dileber.tools;

/**
 * Created by shidawei on 16/1/18.
 */
public final class HString {

    public static String concat(String splt,String... args){
        if(args.length<=0){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        for(String temp:args){
            if (temp == null) {
                ret.append(splt).append("null");
            } else {
                ret.append(splt).append(temp);
            }
        }
        return ret.toString();
    }

    public static String concatObject(String splt,Object... args){
        if(args.length<=0){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        for(Object temp:args){
            if (temp == null) {
                ret.append(splt).append("null");
            } else {
                ret.append(splt).append(temp.toString());
            }
        }
        return ret.toString();
    }

}
