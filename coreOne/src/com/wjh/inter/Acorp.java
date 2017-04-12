package com.wjh.inter;

/**
 * Created by WJH on 2017年04月10日 11:04
 */
public class Acorp implements Advertisement{
    @Override
    public void showAdvertisement() {
        System.out.println("AAAAAAAA");
    }

    @Override
    public String getCorpName() {
        return "A crop ";
    }
}
