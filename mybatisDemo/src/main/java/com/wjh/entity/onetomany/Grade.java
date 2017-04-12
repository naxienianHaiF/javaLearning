package com.wjh.entity.onetomany;

import java.util.List;

/**
 * Created by WJH on 2017年03月31日 19:42
 *  班级
 */
public class Grade {
    private String gclass;    //班级
    private String gteacher;  //班主任姓名

    private List<Student> students;

    public String getGclass() {
        return gclass;
    }

    public void setGclass(String gclass) {
        this.gclass = gclass;
    }

    public String getGteacher() {
        return gteacher;
    }

    public void setGteacher(String gteacher) {
        this.gteacher = gteacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gclass='" + gclass + '\'' +
                ", gteacher='" + gteacher + '\'' +
                ", students=" + students +
                '}';
    }
}
