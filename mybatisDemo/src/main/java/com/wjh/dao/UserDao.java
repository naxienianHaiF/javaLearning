package com.wjh.dao;

import com.wjh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by WJH on 2017年03月29日 20:14
 */
public interface UserDao {

    /**
     * 根据uid查询用户信息
     * @param uid 输入要查找的uid
     * @return 从数据库查到的用户User对象
     */
    User getUser(int uid);

    User getUserByParameter(int uid,String uname);

    /**
     * 多参数传递之注解传递方式
     * @param uid 用户uid
     * @param uname 用户名
     * @return 查询到的用户User对象
     */
    User getUserByParameterAnnotation(@Param("wjhid") int uid,@Param("wjhname") String uname);
    List<User> getAll();
    int addUser(User user);
    int deleteUser(int uid);
}
