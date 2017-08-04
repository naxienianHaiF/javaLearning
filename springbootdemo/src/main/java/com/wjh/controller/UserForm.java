package com.wjh.controller;

import java.util.List;

/**
 * Created by WJH on 2017年07月31日 22:34
 */
public class UserForm {
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "list=" + list +
                '}';
    }
}
