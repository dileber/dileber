package com.zhonghua.smailadd.app;

import com.zhonghua.dileber.app.SApplication;
import com.zhonghua.dileber.data.db.DBManager;
import com.zhonghua.dileber.tools.SLog;
import com.zhonghua.smailadd.LocalModel.User;
import com.zhonghua.smailadd.db.UserMapper;

import java.util.*;

/**
 * Created by shidawei on 16/1/21.
 */
public class SmailApplication extends SApplication{

    public static DBManager user;

    @Override
    public void onCreate() {
        super.onCreate();
        buglog(Configer.BUG_STATIC, Configer.BUG_NAME);
        List<String> list = new ArrayList<String>();

        StringBuffer sBuffer = new StringBuffer();

        String s = "CREATE TABLE user (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name TEXT,age INTEGER,info TEXT)";
        list.add(s);
        user = DBManager.getInstance().getDB(Configer.DB_NAME,Configer.DB_VERSION,list);

        UserMapper userMapper = user.loadMapper(UserMapper.class);

        SLog.w("ddddddddd");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "22211");
        map.put("age", 51L);
        map.put("info", "111");
        List<Map<String,Object>> lisd = new ArrayList<Map<String, Object>>();
        lisd.add(map);
        userMapper.insert(lisd);

        User mm = userMapper.select2();
        SLog.i(mm.getInfo(),mm.getAge(),mm.getName());

        List<User> users = null;
        try {
            //users = user.queryData2T("select * from user", null, User.class);
            users = userMapper.select();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        List<User> users = userMapper.select();
        for(int i =0;i<users.size(); i++) {
            SLog.i("sssssssss" + users.get(i).getName(),users.get(i).getInfo(),String.valueOf(users.get(i).getAge()));
        }

    }
}
