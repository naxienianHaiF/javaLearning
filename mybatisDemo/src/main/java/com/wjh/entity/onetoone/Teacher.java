package com.wjh.entity.onetoone;

/**
 * Created by WJH on 2017年03月30日 20:08
 *  设定一个老师只负责一个班
 */
public class Teacher {
    private String tid;     //老师班级
    private String tname; //老乡姓名

    public Teacher(){
    }

    public Teacher(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
