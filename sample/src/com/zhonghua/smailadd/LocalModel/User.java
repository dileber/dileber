package com.zhonghua.smailadd.LocalModel;

/**
 * Created by shidawei on 16/2/9.
 * CREATE TABLE user (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,name TEXT,age INTEGER,info TEXT)
 */
public class User {

    Integer _id;

    String name;

    Integer age;

    String info;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
