package com.wjh.entity.onetoone;

/**
 * Created by WJH on 2017年03月30日 22:52 http://www.cnblogs.com/xdp-gacl/p/4264440.html
 */
public class Classes {
    private String cid; //班级
    private String cname; //班级学生姓名
    private Teacher teacher;

    @Override
    public String toString() {
        return "Classes{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
