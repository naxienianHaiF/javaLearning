package com.wjh.entity;

/**
 * Created by WJH on 2017年03月29日 20:43
 */
public class User {
    private int uid;
    private String uname;
    private int age;

    public User() {
    }

    public User(int uid, String uname, int age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }
}
