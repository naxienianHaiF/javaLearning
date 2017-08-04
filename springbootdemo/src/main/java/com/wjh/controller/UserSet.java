package com.wjh.controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by WJH on 2017年08月02日 23:19
 */
public class UserSet {
    private Set<User> set;

    public UserSet() {
        set=new HashSet<User>();
        set.add(new User());
        set.add(new User());
    }

    public UserSet(Set<User> set) {
        this.set = set;
    }

    public Set<User> getSet() {
        return set;
    }

    public void setSet(Set<User> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "UserSet{" +
                "set=" + set +
                '}';
    }
}
