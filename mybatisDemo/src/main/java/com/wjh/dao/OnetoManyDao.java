package com.wjh.dao;

import com.wjh.entity.onetomany.Grade;
import com.wjh.entity.onetomany.Student;

import java.util.List;

/**
 * Created by WJH on 2017年03月31日 21:28
 */
public interface OnetoManyDao {
    Grade getGrade(String string);

    List<Student> getStudent(String string);
    Grade getGrade2(String string);
}
