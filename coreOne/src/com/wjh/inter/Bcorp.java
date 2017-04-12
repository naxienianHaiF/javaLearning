package com.wjh.inter;

/**
 * Created by WJH on 2017年04月10日 11:05
 */
public class Bcorp implements Advertisement {
    @Override
    public void showAdvertisement() {
        System.out.println("BBBBBBBB");
    }

    @Override
    public String getCorpName() {
        return "B corp";
    }
}
