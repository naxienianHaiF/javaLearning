package com.wjh.entity;

/**
 * Created by WJH on 2017年05月15日 19:20
 */
public class WJH {
    public WJH() {
    }

    private int id;
    private String wname;
    private String wp;

    public WJH(int id, String wname, String wp) {
        this.id = id;
        this.wname = wname;
        this.wp = wp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    @Override
    public String toString() {
        return "WJH{" +
                "id=" + id +
                ", wname='" + wname + '\'' +
                ", wp='" + wp + '\'' +
                '}';
    }
}
