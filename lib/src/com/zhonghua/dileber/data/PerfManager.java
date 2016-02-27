package com.zhonghua.dileber.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.zhonghua.dileber.app.FrameContants;
import com.zhonghua.dileber.app.SApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by shidawei on 16/1/21.
 */
public class PerfManager {

    private static volatile PerfManager instance;

    public static PerfManager getInstance() {
        if (instance == null) {
            synchronized (PerfManager.class) {
                instance = new PerfManager();
            }
        }
        return instance;
    }

    private Map<String, SharedPreferences> prefs;

    private PerfManager() {
        prefs = new HashMap<String,SharedPreferences>();
    }

    public SharedPreferences getPreferance(String name) {
        if (name == null) {
            name = SApplication.getInstance().getPackageName() + "_preferences";
        }
        if (!prefs.containsKey(name)) {
            SharedPreferences pref = SApplication.getInstance()
                    .getSharedPreferences(name, Context.MODE_PRIVATE);
            prefs.put(name, pref);
        }
        return prefs.get(name);
    }


    /**
     * 保存在手机里面的文件名
     */
    public static final String FILE_NAME = "share_data";

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param key
     * @param object
     */
    public synchronized boolean put(String name,String key, Object object)
    {

        SharedPreferences sp = getPreferance(name);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String)
        {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer)
        {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean)
        {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float)
        {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long)
        {
            editor.putLong(key, (Long) object);
        } else if (object instanceof Set)
        {
            editor.putStringSet(key,(Set<String>)object);
        }
        else
        {
            editor.putString(key, object.toString());
        }

        return editor.commit();
    }


    public synchronized boolean putSome(String name,Map<String,Object> map)
    {
        SharedPreferences sp = getPreferance(name);
        SharedPreferences.Editor editor = sp.edit();

        for (String key : map.keySet()) {

            Object object = map.get(key);

            if (object instanceof String)
            {
                editor.putString(key, (String) object);
            } else if (object instanceof Integer)
            {
                editor.putInt(key, (Integer) object);
            } else if (object instanceof Boolean)
            {
                editor.putBoolean(key, (Boolean) object);
            } else if (object instanceof Float)
            {
                editor.putFloat(key, (Float) object);
            } else if (object instanceof Long)
            {
                editor.putLong(key, (Long) object);
            } else if (object instanceof Set)
            {
                editor.putStringSet(key,(Set<String>)object);
            }
            else
            {
                editor.putString(key, object.toString());
            }

        }

        return editor.commit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param key
     * @param defaultObject
     * @return
     */
    public synchronized Object get(String name,String key, Object defaultObject)
    {
        SharedPreferences sp = getPreferance(name);

        if (defaultObject instanceof String)
        {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer)
        {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean)
        {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float)
        {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long)
        {
            return sp.getLong(key, (Long) defaultObject);
        } else if (defaultObject instanceof Set)
        {
            return sp.getStringSet(key, (Set<String>) defaultObject);
        }

        return null;
    }


    public synchronized Object getSystmPreferences(String key, Object defaultObject){
        return get(FrameContants.SYSTEM_PREFERANCE,key,defaultObject);
    }


    public synchronized boolean clearSystemPreferences(){
        SharedPreferences sp = getPreferance(FrameContants.SYSTEM_PREFERANCE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }

    public synchronized boolean putSystemPreferences(String key, Object object){
        return put(FrameContants.SYSTEM_PREFERANCE,key,object);
    }


    /**
     * 移除某个key值已经对应的值
     * @param key
     */
    public synchronized boolean remove(String name, String key)
    {
        SharedPreferences sp = getPreferance(name);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        return editor.commit();
    }

    /**
     * 清除数据
     */
    public synchronized boolean clear(String name)
    {
        SharedPreferences sp = getPreferance(name);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }



    /**
     * 查询某个key是否已经存在
     * @param key
     * @return
     */
    public synchronized boolean contains(String name, String key)
    {
        SharedPreferences sp = getPreferance(name);
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     *
     * @return
     */
    public synchronized Map<String, ?> getAll(String name)
    {
        SharedPreferences sp = getPreferance(name);
        return sp.getAll();
    }


}
