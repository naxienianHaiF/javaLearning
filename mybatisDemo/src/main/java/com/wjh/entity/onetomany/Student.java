package com.wjh.entity.onetomany;

/**
 * Created by WJH on 2017年03月31日 19:39
 */
public class Student {
    private String sname;   //学生姓名
    private String sclass;  //班级

    public Student(){}

    public Student(String sname, String sclass) {
        this.sname = sname;
        this.sclass = sclass;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                '}';
    }
}
