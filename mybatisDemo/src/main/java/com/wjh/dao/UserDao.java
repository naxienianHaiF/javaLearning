package com.wjh.dao;

import com.wjh.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by WJH on 2017年03月29日 20:14
 */
public interface UserDao {

    User getUser(int uid);
    User getUserByParameter(int uid,String uname);
    User getUserByParameterAnnotation(@Param("uid") int uid,@Param("uname") String uname);
    List<User> getAll();
    int addUser(User user);
    int deleteUser(int uid);
}
