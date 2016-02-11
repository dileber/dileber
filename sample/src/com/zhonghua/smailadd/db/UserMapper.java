package com.zhonghua.smailadd.db;

import com.zhonghua.dileber.data.db.annotation.Clazz;
import com.zhonghua.dileber.data.db.annotation.Insert;
import com.zhonghua.dileber.data.db.annotation.Select;
import com.zhonghua.smailadd.LocalModel.User;

import java.util.List;
import java.util.Map;

/**
 * Created by shidawei on 16/2/9.
 */
public interface UserMapper{

    @Insert("Insert into user(name,age,info) values (#{name},#{age},#{info})")
    long insert(Map<String,Object> map);


    @Insert("Insert into user(name,age,info) values (#{name},#{age},#{info})")
    int insert(List<Map<String,Object>> list);


    @Clazz("com.zhonghua.smailadd.LocalModel.User")
    @Select("select * from user")
    List<User> select();

    @Select("select * from user limit 1")
    User select2();


}
